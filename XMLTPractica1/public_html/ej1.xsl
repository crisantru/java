<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejemplo 1</title>
            </head>
            <body>
                <h2>Coleccion de Discos</h2>
                <table border="3">
                    <tr>
                        <th>Titulo album</th>
                        <th>Artista</th>
                        <th>Precio</th>
                    </tr>
                    <tr>
                        <td><xsl:value-of select="catalog/cd/title"/></td>
                        <td><xsl:value-of select="catalog/cd/artist"/></td>
                        <td><xsl:value-of select="catalog/cd/price"/></td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
