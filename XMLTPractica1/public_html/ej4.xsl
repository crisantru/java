<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejemplo Usando choose</title>
            </head>
            <body>
                <h2>Coleccion de Discos</h2>
                <table border="3">
                    <tr bgcolor="#1acd32">
                        <th>Titulo album</th>
                        <th>Artista</th>
                        <th>Precio</th>
                    </tr>
                    <!--<xsl:for-each select="catalog/cd[artist='Bonnie Tyler']"> -->
                    <xsl:for-each select="catalog/cd"> 
                        <tr>
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="artist"/></td>
                            
                            <xsl:choose>
                                <xsl:when test="price &gt; 10">
                                    <td bgcolor="#ff00ff"><xsl:value-of select="price"/></td>
                                </xsl:when>
                                <xsl:otherwise>
                                    <td bgcolor="#00ffff">Oferta $ <xsl:value-of select="price"/></td>    
                                </xsl:otherwise>
                            </xsl:choose>
                            
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>