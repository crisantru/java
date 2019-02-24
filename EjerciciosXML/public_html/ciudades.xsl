<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejercicio 1</title>
            </head>
            <body>
                <h2>Ciudades</h2>
                <table border="3">
                    <tr bgcolor="#1acd32">
                        <th>Nombre</th>
                        <th>Continente</th>
                    </tr>
                    <!--<xsl:for-each select="catalog/cd[artist='Bonnie Tyler']"> -->
                    <xsl:for-each select="ciudades/ciudad"> 
                        <tr>
                            <td><xsl:value-of select="nombre"/></td>
                            <td><xsl:value-of select="pais"/></td>
                                                
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>