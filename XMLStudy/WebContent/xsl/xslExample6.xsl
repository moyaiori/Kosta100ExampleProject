<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html" encoding="utf-8" />
	
	<!-- 시작 템플레이트 룰 -->
	<xsl:template match="/">
		<html>
			<body>
				<h2>
					<font color="blue">도서 목록</font>
				</h2>
				<table border="1" cellspacing="0" width="50%">
					<tr bgcolor="#FFFF66">
						<th>no</th>
						<th>title</th>
						<th>author</th>
					</tr>

					<!-- book 템플레이트 룰 적용 -->
					<xsl:apply-templates select="/booklist/book" />

				</table>
			</body>
		</html>
	</xsl:template>

	<!-- book 템플레이트 룰 -->
	<xsl:template match="book">
		<tr>
			<td align="center">
				<xsl:number format="1" />
			</td>
			<td>
				<xsl:value-of select="title" />
			</td>
			<td>
				<xsl:value-of select="author" />
			</td>
		</tr>
	</xsl:template>

</xsl:stylesheet>