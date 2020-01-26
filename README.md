# Warehouse

* Naudojima Java versija: **1.8.0_191**
* CSV failai talpinami projekto direktorijoje, csv kataloge.

- [x] Peržiūrėti trūkstamų prekių kiekius.
- [x] Patikrinti prekes, kurių galiojimo laikas pasibaigęs arba pasibaigs greitu metu.
- [x] Turi būti pateiktas visas išeities programinis kodas.
- [x] Turi būti pateiktos instrukcijos kaip naudotis informacine sistema. 
 
# Naudojimo instrukcija

* Įjungus programą prašoma nurodyti failo pavadinimą, be prievardžio. Pvz, failo pavadinimas sample.csv, rašoma į konsolę tik sample. Norint užbaikti operaciją įvedamas 0.
* Įvedus teisingą failo pavadinimą galimi du pasirinkimo variantai:
  _ Surasti trūkstančias prekes.
  _ Surasti prekes, kurių galimimo laikas pasibaigęs ir pasibaigs greitu metu.
* Įvedus 1, pasirenkama surasti trūkstančias prekes. Sistema prašys į konsolę įvesti minimalų kiekį prekių. Įvedus teisingą kiekį sistema išves į konsole visas prekes , kurių neužtenka.
* Įvedus 2, pasirenkama surasti prekes, kurių galiomo laikas pasibaigęs arba pasibaigs greitu. Sistema prašys įvesti datą, datos formatas yyyy-MM-dd, t.y. 2020-01-01. Įvedus teisingą datą sistema išves i konsolę visas prekes, kurių galiojimo data pasibaigus arba pasibaigs greitu metu.
* Norint baikti darbą su sistema įvedamas 0.