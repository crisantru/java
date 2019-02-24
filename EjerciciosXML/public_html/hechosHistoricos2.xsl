<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejercicio 2</title>
            </head>
            <body>
                <h2>Hechos Historicos</h2>
                <table border="3">
                    <tr bgcolor="#1acd32">
                        <th>Hecho</th>
                        <th>Fecha</th>
                    </tr>
                    <tr bgcolor="#1acd32">
                        <th></th>
                        <th>Dia</th>
                        <th>Mes</th>
                        <th>Año</th>
                    </tr>
                    
                    <xsl:for-each select="hechos_historicos/hecho">
                        <tr>
                            <td><xsl:value-of select="@descripcion" /></td>
                            <td>
                                <xsl:for-each select="hecho/fecha">
                                    <td>
                                        <xsl:value-of select="dia" />
                                    </td>
                                </xsl:for-each>
                            </td>
                            <td>
                                <xsl:for-each select="hecho/fecha">
                                    <xsl:value-of select="mes" />
                                </xsl:for-each>
                            </td>
                        </tr>
                    </xsl:for-each>                   
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>