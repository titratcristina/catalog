# Programare avansata pe obiecte - proiect

Fiecare student va lucra la un proiect individual. Proiectul este structurat în mai multe etape.

Condiția de punctare a proiectelor:
- să nu prezinte erori de compilare
- să se implementeze cerințele date

Termene de predare:
- Etapa I: săptămâna 3 – 7 aprilie
- Etapa II: săptămâna 24 – 28 mai

## Etapa I
1) **Definirea sistemului** Să se creeze o lista pe baza temei alese cu cel puțin 10 acțiuni/interogări care se pot face în cadrul
   sistemului și o lista cu cel puțin 8 tipuri de obiecte.
2) **Implementare**
   Sa se implementeze în limbajul Java o aplicație pe baza celor definite la primul punct.
   Aplicația va conține:
   - clase simple cu atribute private / protected și metode de acces
   - cel puțin 2 colecții diferite capabile să gestioneze obiectele definite anterior (eg: List, Set, Map, etc.) dintre care cel puțin una sa fie sortata – se vor folosi array-uri uni- /bidimensionale în cazul în care nu se parcurg colecțiile pana la data checkpoint-ului.
   - utilizare moștenire pentru crearea de clase adiționale și utilizarea lor în cadrul colecțiilor;
   - cel puțin o clasă serviciu care sa expună operațiile sistemului
   - o clasa Main din care sunt făcute apeluri către servicii
## Etapa II
1) **Extindeți proiectul din prima etapa prin realizarea persistentei utilizând o baza de date relațională
   si JDBC.**
   Să se realizeze servicii care sa expună operații de tip create, read, update si delete pentru cel puțin 4
   dintre clasele definite. Se vor realiza servicii singleton generice pentru scrierea și citirea din baza de
   date.
2) **Realizarea unui serviciu de audit**
   Se va realiza un serviciu care sa scrie într-un fișier de tip CSV de fiecare data când este executată una
   dintre acțiunile descrise în prima etapa. Structura fișierului: nume_acțiune, timestamp

## Teme sugerate
1) carnet (student, curs, profesor)
2) biblioteca (secțiuni, cărți, autori, cititori)
3) programare cabinet medical (client, medic, programare)
4) gestiune stocuri magazin (categorii, produse, distribuitori)
5) aplicație bancara (conturi, extras de cont, tranzacții, carduri, servicii)
6) platformă e-learning (cursuri, utilizatori, cursanți, quiz-uri)
7) sistem licitații (licitații, bids, produse, utilizatori)
8) platforma food delivery(localuri, comenzi, șoferi, useri)
9) platforma împrumuturi cărți - tip Bookster (companii afiliate, utilizatori, cărți)
10) platforma e-ticketing (evenimente, locații, clienți)

# Documentație proiect - Etapa I

Am ales tema **carnet**. Am implementat un sistem pentru a gestiona notele studenților dintr-o facultate.

## Definirea sistemului

1. Adăugarea unui student în sistem. 
2. Modificarea informațiilor unui student deja existent în sistem. 
3. Ștergerea unui student existent în sistem. 
4. Căutarea unor informații despre un student în sistem. 
5. Afișarea tuturor studenților din sistem. 
6. Sortarea alfabetică a studenților din sistem.
7. Adăugarea unei note pentru un student la un anumit curs 
8. Căutare unei note pentru un anumit student si curs 
9. Ștergere unei note pentru un anumit student si curs 
10. Modificarea unei note pentru un anumit student si curs 
11. Obținerea listei de note pentru un anumit student 
12. Obținerea listei de note pentru un anumit student sortate crescător
13. Obținerea listei de note pentru un anumit curs 
14. Calcularea mediei aritmetice a notelor unui student 
15. Calcularea mediei ponderate a notelor unui student 
16. Calcularea numărului total de credite obținute de un student 
17. Calcularea numărului de puncte de credite obținute de un student 
18. Afișarea listei de cursuri pentru care un student are restanță

## Listă obiecte

- Curs 
- Facultate 
- Specializare 
- Grupa 
- Nota
- Persoana 
- Profesor 
- Student 
- TipLoc

## Implementare

### Clasa Curs 
Reprezintă un curs dintr-o specializare și are următoarele atribute:

- private String numeCurs - numele cursului
- private int numărCredite - numărul de credite asociat cursului
- private String cod - codul unic al cursului
- protected List<Nota> note - lista de note obținute de studenți la acest curs

### Clasa Facultate
Reprezintă o facultate și are următoarele atribute:

- private String numeFacultate - numele facultății
- private String adresa - adresa facultății
- protected List<Specializare> specializări - lista de specializări din cadrul facultății

### Clasa Specializare
Reprezintă o specializare dintr-o facultate și are următoarele atribute:

- private String numeSpecializare - numele specializării
- protected List<Grupa> grupe - lista de grupe din cadrul specializării

### Clasa Grupa
Reprezintă o grupă de studenți și are următoarele atribute:

- private String nume - numele grupei
- protected List<Student> studenți - lista de studenți din grupă

### Clasa Nota
Reprezintă o notă obținută de un student la un curs și are următoarele atribute:

- private int valoare - valoarea notei obținute
- private Student student - studentul care a obținut nota
- private Curs curs - cursul la care s-a obținut nota

### Clasa Persoana
Reprezintă o persoană și are următoarele atribute:

- private String nume - numele persoanei
- private String prenume - prenumele persoanei
- private String CNP - CNP-ul persoanei
- private int id - id-ul unic al persoanei

### Clasa Profesor
Reprezintă un profesor și are următoarele atribute:

- moștenește atributele din clasa Persoana
- protected List<Curs> cursuri - lista de cursuri predate de profesor

### Clasa Student
Reprezintă un student și are următoarele atribute:

- moștenește atributele din clasa Persoana
- private int anStudiu - anul de studiu al studentului
- private TipLoc tipLoc - tipul de loc (buget sau taxă) al studentului
- protected List<Curs> cursuri - lista de cursuri la care sunt înscriși studenții

### Enumerarea TipLoc:
Reprezintă tipul locului pentru un student (buget sau taxă)

- BUGET
- TAXA

### Clasa IDGenerator:
Un generator de id-uri pentru persoanele adăugate în sistem

- private static int nextID = 1;

### Serviciul StudentService
Serviciul NoteService expune operațiile sistemului prin care se gestionează studenții:

- Adăugăm studenții într-o listă și un set
- Afișare listă de studenți
- Căutare student după id
- Afișare setul de studenți sortat după nume
- Afișare studenții care sunt la taxă
- Ștergerea unui student din listă
- Modificarea un student

### Serviciul NoteService
Serviciul NoteService expune operațiile sistemului prin care se gestionează notele studenților la cursuri, folosind acest serviciu putem:
- adăuga note într-o listă
- căuta o notă pentru un student la un curs
- afișa notele unui student
- afișa notele unui student crescător
- afișare notele de la un curs
- calcula media aritmetică a unui student
- calcula media ponderată a unui student
- calcula numărul de credite ale unui student
- calcula numărul de puncte credit ale unui student
- afișa restanțele unui student
- șterge o notă pentru un student la un curs
- modificare notă pentru un student la un curs

Pentru celelalte servicii am folosit operații de adăugare, ștergere, afișare și modificare pe liste

