package kr.or.kosta.koback.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
/*
 * 2015 02 19 (오후 2시)
 * 틀 구현 : 조현빈
 * */

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.kosta.koback.common.MessageType;
import kr.or.kosta.koback.model.FileDao;
import kr.or.kosta.koback.model.Files;
import kr.or.kosta.koback.server.ProgressDialog;
import kr.or.kosta.koback.util.GUIUtil;
import kr.or.kosta.koback.view.chatroom.ChatUI;
import kr.or.kosta.koback.view.fileshare.UserFileFrame;
import kr.or.kosta.koback.view.login.UserLoginPanel;

public class ChatClient {

	private boolean stop;
	private String serverIp;
	private int port;
	private Socket socket;
	private DataInputStream in;
	private DataInputStream in2;
	private DataOutputStream out;
	private DataOutputStream out2;
	private ChatUI ui;
	private FileDao dao;
	/* 08.22 추가 (조현빈) */
	private ReceiveMessageMethod receiveMessageMethod; //
	JPanel screen;
	UserFileFrame fileFrame;

	public ChatClient() {

	}

	public ChatClient(int port, String ip) {
		this.port = port;
		this.serverIp = ip;
	}

	// 클라이언트 구동
	public void connect() throws IOException {
		socket = new Socket(serverIp, port);
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());
		/* 08.22 추가 (조현빈) */
		receiveMessageMethod = new ReceiveMessageMethod(ui);
		fileFrame = getUi().getChatRoomPanel().getUserFileFrame();
	}

	// 클라이언트 구동
	public void filelConnect(String serverIp, int port) throws IOException {
		socket = new Socket(serverIp, port);
		out2 = new DataOutputStream(socket.getOutputStream());
		in2 = new DataInputStream(socket.getInputStream());
	}

	// 메세지 수신 ----아이디가 1번
	public void receiveMessage() throws IOException {
		new Thread() {
			@Override
			public void run() {
				try {
					while (!isStop()) {
						String responeMessage = null;
						while (responeMessage == null || "".equals(responeMessage)) {
							responeMessage = in.readUTF();
						}

						String[] tokens = responeMessage.split(MessageType.DELIMETER);
						String messageCode = tokens[0];
						/*------------------switch - case 문 시작 부분 --------------------------*/
						switch (messageCode) {

						/* [101] 로그인결과응답 */
						case MessageType.S_LOGIN_RESULT:
							String Result = tokens[2];
							String message = tokens[3];

							String connectionId = tokens[1]; // 로그인 요청 한 클라이언트의
																// 닉네임
							String waitingList = tokens[3]; // 대기실에 접속 되어있는
															// 클라이언트 목록.
							String chatRoomLists = tokens[4];
							if (new Boolean(Result))
								receiveMessageMethod.sLoignResult(connectionId, waitingList, chatRoomLists);
							else
								receiveMessageMethod.sLogin(new Boolean(Result), message);

							break;

						/* [103] 회원가입 응답 결과 */
						case MessageType.S_JOIN_RESULT:
							/*
							 * System.out.println("[[103] 회원가입 응답 결과] : " +
							 * responeMessage);
							 */
							String result = tokens[1];
							String Message = tokens[2];
							receiveMessageMethod.sJoinResult(new Boolean(result), Message);
							break;

						/*
						 * 수정사항 : 08 - 24 수정 :조현빈
						 */
						/*
						 * [201] 채팅방 개설 결과 응답
						 * 201=jo930408=방번호=제목=true=아이디|true|아이디|true
						 */
						case MessageType.S_OPEN_RESULT:

							/*
							 * 인자 값 : roomOpenResult
							 * ,roomTitle(tokens[3]),roomNum(tokens[2]),list(
							 * tokens[6])
							 */
							ui.getChatRoomPanel().chatRoomList(tokens[6]);
							receiveMessageMethod.sOpenResult(new Boolean(tokens[5]), tokens[3], tokens[2], tokens[6]);
							break;

						/*
						 * 수정사항 : 08 - 24 수정 :조현빈
						 */
						/* [203] 비밀방 개설 응답|203|jo930408|방번호|제목|인원|true */
						case MessageType.S_SECRET_RESULT:

							/*
							 * 인자 값 : roomNum(tokens[2])
							 * roomTitle(tokens[3]),roomOpenResult(tokens[6]),
							 * list(tokens[7])
							 */
							ui.getChatRoomPanel().chatRoomList(tokens[7]);
							receiveMessageMethod.sSecretResult(tokens[2], tokens[3], new Boolean(tokens[6]), tokens[7]);
							break;

						/*
						 * 수정사항 : 08 - 24 수정 :조현빈
						 */
						/* [211] 채팅방 입장 결과 응답 : 변경 */
						case MessageType.S_ENTRY_RESULT:

							/*
							 * 인자값 : RoomOpenResult(tokens[2]),
							 * roomTitle(tokens[3]) , roomNum(tokens[4])
							 */
							boolean roomOpenResult = Boolean.valueOf(tokens[2]);

							if (roomOpenResult) {
								ui.getChatRoomPanel().chatRoomList(tokens[5]);
								receiveMessageMethod.sEntryResult(roomOpenResult, tokens[3], tokens[4]);
							} else
								receiveMessageMethod.errorMessage(roomOpenResult, tokens[3]);
							break;

						/*
						 * 수정사항 : 08 - 24 수정 :조현빈
						 */
						/* [213] 비밀방 입장 결과 응답 */
						case MessageType.S_SECRET_ENTRY_RESULT:

							/*
							 * 인자값 : RoomOpenResult(tokens[2]),
							 * roomTitle(tokens[3]) , roomNum(tokens[4])
							 */
							boolean secretRoomOpenResult = Boolean.valueOf(tokens[2]);

							if (secretRoomOpenResult) {
								ui.getChatRoomPanel().chatRoomList(tokens[5]);
								receiveMessageMethod.sEntryResult(secretRoomOpenResult, tokens[3], tokens[4]);
							} else
								receiveMessageMethod.errorMessage(secretRoomOpenResult, tokens[3]);
							break;

						/* [215] 초대 입장 응답 */
						case MessageType.S_INVITE_ENTRY:
							Boolean chatRoomResult = Boolean.valueOf(tokens[2]);
							String roomTitle = tokens[3];
							// System.out.println("[[211] 채팅방 입장 결과
							// 응답]"+responeMessage);
							if (chatRoomResult) {
								String roomNum = tokens[4];
								UserLoginPanel.userRoom = Integer.valueOf(roomNum);
								ui.getChatRoomPanel().chatRoomOpenS(chatRoomResult, roomTitle, roomNum);

							} else {
								String messgae = tokens[3];
								ui.getChatRoomPanel().chatRoomOpenS(chatRoomResult, messgae);
							}
							break;

						/* [300]채팅메세지 수신 결과 응답 */
						case MessageType.SC_CHAT_MESSAGE:
							/*
							 * System.out.println("[[300]채팅메세지 수신 결과 응답]" +
							 * responeMessage);
							 */
							String messageId = tokens[1];
							String chatMessage = tokens[3];
							ui.getChatRoomPanel().setMessage("[" + messageId + "] : " + chatMessage);
							break;

						/* [301] 이모티콘 송수신 응답 */
						case MessageType.SC_CHAT_EMOTICON: //
							String sendId = tokens[1];
							String filePath = tokens[3];
							ui.getChatRoomPanel().setEmoticon(filePath, sendId);
							break;

						/* [302] 귓속말 송수신 */
						case MessageType.SC_WHISPER:
							String id = tokens[1];
							String whisperMessage = tokens[4];
							ui.getChatRoomPanel().setMessage("[" + id + "] : " + whisperMessage);
							break;

						/* [303] 초대 요청 */
						case MessageType.C_INVITE_USER:
							break;

						/* [304] 초대 응답 */
						case MessageType.S_INVITE_RESULT:
							ui.getChatRoomPanel().setMasterID(tokens[1]);
							ui.getChatRoomPanel().setRoomNum(tokens[2]);
							ui.getChatRoomPanel().showInvitePan();
							break;

						/* [305] 초대에 대한 응답 */
						case MessageType.C_INVITE_CONFIRM:
							String inviteUser = tokens[1];
							if (tokens[3] == "true") {
								ui.getChatRoomPanel().acceptInvite(inviteUser);
							} else {
								ui.getChatRoomPanel().acceptInvite(inviteUser);
							}
							break;

						/* [307] 강퇴당한 아이디 ? 방장아이디?|비밀번호|개설된 방정보 목록|대기자 목록 */
						case MessageType.S_KICK:
							String kickId = tokens[1];
							if (tokens.length <= 3)
								receiveMessageMethod.scExit(UserLoginPanel.userId, tokens[3], tokens[4]);
							else {
								if (!(tokens.length <= 3))
									receiveMessageMethod.scExit(UserLoginPanel.userId, tokens[3], tokens[4]);
								else
									receiveMessageMethod.scExit(UserLoginPanel.userId, tokens[3], null);
							}
							break;

						/* [308] 아이디|비밀번호|개설된 방정보 목록|대기자 목록 */
						case MessageType.SC_EXIT:
							// 인자값 :
							// userId(tokens[2]),waitingList(tokens[3]),chatRoomLists(tokens[4])
							if (tokens.length <= 3)
								receiveMessageMethod.scExit(UserLoginPanel.userId, tokens[3], tokens[4]);
							else {
								if (!(tokens.length <= 3))
									receiveMessageMethod.scExit(UserLoginPanel.userId, tokens[3], tokens[4]);
								else
									receiveMessageMethod.scExit(UserLoginPanel.userId, tokens[3], null);
							}
							break;

						/* [309] 대기인 인원 요청 */
						case MessageType.SC_REQUEST_ROOM_INFO:
//							System.out.println("responeMessage : " + responeMessage);
							if (tokens.length <= 2) {
								// System.out.println("대기실 인원 없음");
								ui.getChatRoomPanel().InviteFrameisEmpty();
							} else {
								ui.getChatRoomPanel().InviteFrameOpen(tokens[2], tokens[3], tokens[4]);
							}
							break;

						/* [311] 대기자 목록 수정)0824 조현빈 */
						case MessageType.S_REQUEST_WAITING_LIST:
//							System.out.println("responeMessage : " + responeMessage);
							if (tokens.length <= 2) {
								 System.out.println("[311] 대기자 목록 대기실 인원 없음");
							} else {
								String waitingLists = tokens[2];
								receiveMessageMethod.sRequestWaitingList(waitingLists);
							}
							break;

						/* [312] 개설된 방정보 목록 */
						case MessageType.S_REQUEST_WAITING_ROOMLIST:
							System.out.println("[312] responeMessage : " + responeMessage);
							String waitingRoomLists = tokens[2];
							receiveMessageMethod.sRequestWaitingRoomList(waitingRoomLists);
							break;

						/* [313] 채팅방 참여자 정보를 보내줌 - user가 나갈때 또는 들어올때 */
						case MessageType.S_SELECTED_ROOM_USERLIST:
							String chatUserLists = tokens[2];
							ui.getChatRoomPanel().chatRoomList(chatUserLists);
							break;

						/* [403] 파일 업로드 결과 응답 */
						case MessageType.S_UPLOAD_RESULT: // 파일 업로드 결과
															// EX)[protocol][TRUE]
							String fileName = tokens[2];
							int fileServerPort = Integer.valueOf(tokens[4]);
							String fileServerIp = tokens[5];
							fileServerConnect(fileServerPort, fileServerIp);
							break;
						case MessageType.S_FILE_DOWNLOAD:
							fileName = tokens[2];
							fileServerPort = Integer.valueOf(tokens[4]);
							fileServerIp = tokens[5];
							downloadConnect(fileServerPort, fileServerIp, fileName);
							break;
						/* 405 */
						case MessageType.S_SHOW_FILE_LIST:
							System.out.println(responeMessage);
							String fileList = tokens[2];
							String fileSize = tokens[3];
							String[] files = fileList.split(",");
							String[] size = fileSize.split(",");
							for (int i = 0; i < files.length; i++) {
								Files f = new Files(i + 1, files[i], size[i]);
								fileFrame.getFilesTableModel().getFiles().addElement(f);
							}
							fileFrame.getFilesTableModel().fireTableDataChanged();
							break;

						/* [500] 서버 공지 수신 결과 응답 */
						case MessageType.S_NOTICE:
							// System.out.println(responeMessage);
							String admin = tokens[1];
							String adminMessage = tokens[2].trim();
							ui.getChatRoomPanel().noticeMessage("[" + admin + "] : " + adminMessage);
							break;

						/* [501] 관리자의 귓속말 결과 응답 */
						case MessageType.S_ADMIN_WHISPER: //
							// System.out.println(responeMessage);
							String adminW = tokens[1];
							String adminWhiseper = tokens[2].trim();
							ui.getChatRoomPanel().noticeWhisperMessage("[" + adminW + "]님의 귓속말 : " + adminWhiseper);
							break;
						}
					}
				} catch (IOException e) {
					System.out.println("서버가 종료되었습니다.");
				}
			}
		}.start();
	}

	public void openChatRoom() {
		ui.setSize(1000, 600);
		GUIUtil.setCenterScreen(ui);
		ui.showCard("chatRoom");
	}

	/* [403] */
	public void fileServerConnect(int fileServerPort, String fileServerIp) {

		try {
			filelConnect(fileServerIp, fileServerPort);
			fileUpload();

		} catch (IOException e) {
			String erreorMessage = "아래와 같은 예외가 발생하여 서버를 구동 할 수 없습니다.\r\n" + e.toString();
			JOptionPane.showMessageDialog(null, erreorMessage, "연결실패", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void downloadConnect(int fileServerPort, String fileServerIp, String fileName) {
		try {
			filelConnect(fileServerIp, fileServerPort);
			fileDownload(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean resultResult(String result) {
		if (result.equals("true"))
			return true;
		return false;
	}

	public void fileUpload() throws IOException {
		new Thread() {
			@Override
			public void run() {
				dao = getUi().getChatRoomPanel().getUserFileFrame().getDao();
				File file = new File(dao.getFilePath()); // 파일 객체만들기.

				FileInputStream fin = null;
				try {
					fin = new FileInputStream(file);
					byte[] buffer = new byte[1024];
					int count = 0;
					int size = 0;
					while ((count = fin.read(buffer)) != -1) {
						size += count;
						System.out.println(size);
						out2.write(buffer, 0, count);
					}

					String responeFileshare = in2.readUTF();
					String[] token = responeFileshare.split(MessageType.DELIMETER);
					String shareCode = token[0];
					switch (shareCode) {
					/* [410]파일 리스트 업로드 결과 응답 */
					case MessageType.S_ALLFILE_LIST: // 파일 업로드 결과
														// EX)[protocol][TRUE]
						System.out.println("[410 서버에게 받은 메세지]" + responeFileshare);
						int up = Integer.parseInt(token[2]);
						String uploadFileName = token[3];
						String fileSize = token[4];
						Files files = new Files(up, uploadFileName, fileSize);
						fileFrame.getFilesTableModel().getFiles().addElement(files);
						fileFrame.getFilesTableModel().fireTableDataChanged();
						break;
					}
				} catch (FileNotFoundException e) {
				} catch (IOException e) {
				} finally {
					// if(fin != null) fin.close();
				}
			}
		}.start();
	}

	public void fileDownload(String fileName){
		new Thread() {
			@Override
			public void run() {
				
				File file = new File("D:/AS/", fileName);
				System.out.println(serverIp +" "+ port+ " " + fileName);
				
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(file);
				} catch (FileNotFoundException e1) {
				}
				byte[] buffer = new byte[1024];
				int count = 0;
				long size = 0;
				int copySize = 0;
				try {
					size = in2.readLong();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				ProgressDialog dialog = new ProgressDialog(null, fileName);
				dialog.setComponents();
				dialog.setSize(350, 120);
				dialog.eventRegist();
				GUIUtil.setCenterScreen(dialog);
				GUIUtil.setLookAndFeel(dialog, GUIUtil.THEME_NIMBUS);
				dialog.setVisible(true);
				dialog.setProgressValue(50);
				int copyPer = 0;
				try {
					while ((count = in2.read(buffer)) != -1) {
						System.out.println("찍힘 : " + count);
						fos.write(buffer, 0, count);
						copySize += count;
						 copyPer = (int)(((double)copySize/size) * 100);
						 dialog.setProgressValue(copyPer);
						 if(copyPer == 100) break;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						in2.close();
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("올수있음?");

			}
		}.start();
	}

	public void sendMessage(String message) throws IOException { // chat
		out.writeUTF(message);
	}

	// 클라이언트 종료
	public void disConnect() throws IOException {

		if (socket != null) {
			System.out.println("테스트");
			socket.close();
		}
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public DataInputStream getIn() {
		return in;
	}

	public void setIn(DataInputStream in) {
		this.in = in;
	}

	public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	public ChatUI getUi() {
		return ui;
	}

	public void setUi(ChatUI ui) {
		this.ui = ui;
	}

}
