##Aihemäärittely#

**Aihe:** Ristinolla

Toteutukseen aiheena on perinteinen ristinolla -peli. Pelistä luodaan ensin logiikkapuoli, jonka jälkeen alan toteuttamaan pelin graafista puolta. Pelin on tarkoitus toimia siis ikkunassa, jossa oma pelivuoro pelataan hiiren klikkauksella. Suunnitelmissa olisi tehdä peliin myös aloitusikkuna, johon voisi tarvittaessa laittaa lisäominaisuuksien valintoja. Pelin päättyessä mahdollisuus palata päävalikkoon tai pelata uusi peli. 

Peli on tarkoitettu kahdelle hengelle pelattavaksi. Jatkokehitystä varten peliin jää tehtäväksi tekoäly, joka mahdollistaisi yksinpelin. Myös laajennettavan kentän ominaisuus jää odottamaan jatkokehitystä. 

**Käyttäjät:** Pelaajat 1 ja 2.

**Käyttäjien toiminnot:** Pelaaja aloittaa pelin päävalikosta. Pelin pelaaminen tapahtuu klikkaamalla hiirellä pelikenttää ja valitsemalla haluamansa ruudut. Pelin päätyttyä pelin voi aloittaa nappia painamalla uudelleen.

**Rakennekuvaus:** 
Peli sisältää neljä pääluokkaa(Game, Board, GUI, DrawBoard). Pelin käynnistäminen tapahtuu main-luokasta, joka luo uuden GUI-luokan olion. GUI-luokka taas luo muut aiemmin mainitsemani pääluokat. Game ja Board -luokkien oliot luodaan konstruktorissa, joista Board ensin, ja sitten se annetaan Game-luokalle parametrina. GUI luokka toteuttaa rajapinnan Runnable ja perii luokan JFrame, jotta voimme tässä luokassa helposti luodan ohjelman ulkoasun melko helposti. 

Pelin logiikkaa on hajautettu luokkiin Game ja Board. Nimensä mukaisesti Game tarkastaa yleisesti pelaajan siirtoja ja varmistaa, että kaikki menee muutenkin oikein. Boardissa taas nimensä mukaisesti varmistetaan pelikentän oikeanlainen toimivuus, alustetaan pelikenttä ja päivitetään siirrot. Osa Game-luokan metodeista kutsuu myös monia Board-luokan metodeita tehdäkseen päätelmiä pelitilanteesta. 

Ohjelman DrawBoard -luokka nimensä mukaisesti huolehtii kaikista pelikentälle piirrettävistä elementeistä mukaanlukien pelikenttä ja pelaajien pelimerkit(X ja O).
DrawBoardissa pelikenttä piirretään aluksi tyhjäksi ja klikkaustenkuuntelijan ohjeiden mukaisesti luokka piirtää sen hetkisen pelaajan pelimerkin kentälle, minne pelaaja sen valitsee. 

**Luokkakaavio**

![luokkakaavio](/dokumentaatio/uusiLuokkakaavio.png)

**Sekvenssikaaviot**

Sekvenssikaavio tapaukselle, jossa toinen pelaajista voittaa pelin. Tapaus sisältää myös uuden merkin luomisen kentälle.
![Sekvenssikaavio1](/dokumentaatio/sekvenssikaaviovoitto.png)
Sekvenssikaavio tapaukselle, jossa kenttä tyhjennetään restart -nappia painamalla.
![Sekvenssikaavio2](/dokumentaatio/sekvenssikaaviokentantyhjennys.png)
