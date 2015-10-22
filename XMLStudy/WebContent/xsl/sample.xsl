<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="utf-8"/>
	<!-- xml 문서 자체에 대한 변환 규칙 정의 -->
	<xsl:template match="/">
		<html>
			<head>
				<title>XML문서 -> HTML문서 변환</title>
			</head>
			<body style="font-size:30pt; color:blue;">
				아이디 : <xsl:value-of select="회원/@아이디"/><br/>
				이름 : <xsl:value-of select="회원/이름"/><br/>
				나이 : <xsl:value-of select="회원/나이"/><br/>
				주소 : <xsl:value-of select="회원/주소/시"/> <xsl:value-of select="/회원/주소/구"/> <xsl:value-of select="/회원/주소/동"/>
			</body>			
		</html>
	</xsl:template>
	
</xsl:stylesheet>