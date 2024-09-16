# PSP-2-Uzduotis
Domantas Kemešis 3 grupė
2 Lab

Testai buvo suprantami, bet nebuvo labai gerai parašyti ir nebuvo galima pilnai užtikrinti tinkamo validatoriaus veikimo.

Dauguma testų būvo parašyti šiek tiek neteisingai tikrintai blogą variantą su kokia nors neįgyveninta salygą tada tikrinant jau su ta salyga įgyvendinta ir laikiama, kad bus gražinama teisingai tačiau kitos teisingumo salygos nebūna įgyvendintos 

Pavyzdys.
Viename teste paduodamas slaptažodis "test" jis per trumpas ir validatorius gražina false, testas praeina nes buvo laukiama false.
Tada sekančiui testui paduodama "password123" kuris jau nera per trumpas ir taip tikrinama atvirkštinė salyga prieš tai buvusio testo tačiau šis slaptažodis neturi didžiosios raidės ir specialios raidės ir validatorius gražina false, tačiau laukiama, kad gražins true ir testas nepraeina.
Remiantis tokia logika buvo parašyta dauguma testu ir jie veikė neteisingai, dauguma buvo tiesiog vienodi ir daug testų reikėjo truputi koreguoti.

PasswordChecker Testai:
- buvo keistų pavadinimu kai testai prasideda pavadinimu "passwordLenght" arba "passwordSymbols", reikėtų viską suvienodint ir mano pasiulymas buvo pradėt testą testuojamo metodo pavadinumu ar panašiai.
- Nebuvo numatyta galimybės pasirinkti kokių specialių raidžių reikia, kad slaptožodis tiktų. Sutvarkiau nustatydamas default reikšmes ir suteikiant galimybę jas pakeisti, per setterį.
- Nebuvo testuojama kai paduodama null reikšmė.(papildžiau testu)
- Nebuvo testo kai slaptožodis validus ir validatorius turėtų gražinti true.(papildžiau testu)

EmailValidator Testai:
- Nebuvo testuojama kai paduodama null reikšmė.(papildžiau testu)
- Nebuvo testuojama kai el. pašto vardas, domain ir TLD neleistinų ilgių.(papildžiau testais)
- Nebuvo tikrinimas visos TLD taisykles.(papildžiau testu)
- Testo kur tikrinimas el. pašto vardas buvo sumaišyti leistini su neleistinais simboliais,  parašytas "test&@mail.com" yra leistinas, kad veiktu korektiškai pakoregavau testą.

PhoneNumberValidator Testai:
- Kuriant validatorių kažkodėl budavo paduodami argumentai į konstruktorių ("LT", 13). Šitaip nėra niekaip nustatomas joks telefono numerio prefiksas, o ilgis iš tikro neteisingas, skaičiuojant su "+" turi būt 12 simboliu ilgio. Pakoregavau konstruktorių, kad galima būtų paduoti prefiksa, jį siunčiant vietoj "LT" dalies, nežinau ar čia turėtų but dar kažkoks funkcionalumas pagal šalies vardinį kodą iš kažkokio iš ankstinio sarašo.
- Negalima pridėti papildomų šalių numerių taisyklių, norint naudoti kitokiem numeriam validuoti reikia kurti kito phonenumbervalidator objektą, teoriškai taip naudojant veiktų, bet manau kažkokia galimybė pridėti į vieną validatorių kelių šalių taisykles būtų geriau.
- Nebuvo testuojama kai paduodama null reikšmė.(papildžiau testu)
- Buvo testuojama tiktai per ilgo numerio salyga, bet nebuvo tikrininama per trumpo. (papildžiau testu)

Visi validotoriai pagal testus turėjo gražinti boolean, tačiau manau būtų geriau naudoti exceptionus nes galima paduoti papildomus informacijos kas tiksliai blogai su validuojamu stringu ir tai padėtų labiau patikrinti, kuri iš tikro validavimo taisykle nepraeina taip padėti ir užtikrinti korektiška validatoriaus kodo veikima


