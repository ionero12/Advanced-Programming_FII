# Document Management System
Write an application that can manage a catalog of documents. An entry in this catalog might be an article, a book, etc.
A document may be located using a path in the local file system or a link to an external URL. Each document has a unique ID, a name and may have additional tags, which are pairs name-value. Example of tags may be title, author, year, publishingDate, etc.

The main specifications of the application are:
## Compulsory (1p)

Create an object-oriented model of the problem. You should have at least the following classes: Catalog, Document. Create a class responsible with external operations regarding a catalog.
Implement the following methods representing commands that will manage the content of the catalog:
add: adds a new entry into the catalog;
toString: a textual representation of the catalog;
save: saves the catalog to an external file using JSON format; you may use Jackson or other library;
load: loads the catalog from an external file.

## Homework (2p)
Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe a generic command.
Implement the commands load, list, view, report (create the classes AddCommand, ListCommand, etc.).
list: prints the list of documents on the screen;
view: opens a document using the native operating system application (see the Desktop class);
report: creates (and opens) an HTML report representing the content of the catalog.
Use a template engine such as FreeMarker or Velocity, in order to create the HTML report.
The application will signal invalid data or the commands that are not valid using custom exceptions.
The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR.

## Implementation
Am creeat clasele Document, Catalog, CatalogUtil, InvalidCatalogEception si Main.

Clasa Document contine:
- atributele: id, name, location, si tags
- constructori, gettere, settere, toString()
- metode: addTags() 

Clasa Catalog contine:
- atributele: name si documents
- constructori, gettere, settere, toString()
- metode: addDocuments() si findById() {gaseste un document in functie de id}

Clasa CatalogUtil contine:
- atributul: catalog
- constructori, gettere, settere si toString()
- metode: addDocuments(), save {salveaza un catalog la un anumit path} si load() {incarca un catalog de la un anumit path}

Clasa InvalidCatalogException contine:
- constructor

Clasa Main:
- se declara mai multe obiecte de tip Document, Catalog si CatalogUtil
- se adauga tags la documente
- se afiseaza catalogul utilizand UCatalogUtil
- se salveaza catalogul la un anumit path
- se incarca un catalog de la un anumit path

Clasa AddCommand:
- adauga un document la catalog

Clasa ListCommand:
- afiseaza toate documentele din clasa

Clasa LoadCommand:
- incarca o clasa dintr-un fisier

Clasa ReportCommand:
- genereaza un document HTML

Clasa SaveCommand:
- salveaza catalogul intr-un fisier

Clasa ViewCommand:
- deschide un fisier utilizand aplicatii desktop
