<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejercicio 4</title>
            </head>
            <body>
                <h2>Colores</h2>
                <table border="3">
                    <tr bgcolor="#1acd32">
                        <th>Mezcla</th>
                        <th>Color</th>
                    </tr>
                    <xsl:for-each select="mezclas_de_colores/mezcla"> 
                        <tr>
                            <td><xsl:value-of select="@resultado"/></td>
                            <td><xsl:value-of select="."/></td>
                            
                                                
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>