package com.LLD.LLDProblems.googledocs.simplesolution;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

/**
 * =========================
 * INTERFACE: DocumentElement
 * =========================
 * This is the base interface for all document components (Text, Image, NewLine, Tab).
 * It defines a contract that every element must implement a `render()` method,
 * which converts that element into a displayable string representation.
 */
interface DocumentElement {
    public abstract String render();  // Converts the element into string output
}

/**
 * =========================
 * CLASS: TextElement
 * =========================
 * Represents a plain text component in the document.
 */
class TextElement implements DocumentElement {
    private String text;  // Stores the actual text string

    // Constructor initializes the text to be added
    public TextElement(String text) {
        this.text = text;
    }

    // Converts the TextElement to a plain string when rendering the document
    @Override
    public String render() {
        return text;
    }
}

/**
 * =========================
 * CLASS: ImageElement
 * =========================
 * Represents an image component using the path of the image.
 */
class ImageElement implements DocumentElement {
    private String imagePath;  // Stores image path or name

    // Constructor initializes the image path
    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    // Returns a placeholder string to represent an image in the output
    @Override
    public String render() {
        return "[Image: " + imagePath + "]";
    }
}

/**
 * =========================
 * CLASS: NewLineElement
 * =========================
 * Adds a line break in the document.
 */
class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return "\n";  // Returns newline character to break the line
    }
}

/**
 * =========================
 * CLASS: TabSpaceElement
 * =========================
 * Adds an indentation/tab space to the document.
 */
class TabSpaceElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";  // Returns tab character
    }
}

/**
 * =========================
 * CLASS: Document
 * =========================
 * Acts as a container for all elements (text, image, newline, tab) added by the editor.
 * It holds elements in the order they were added and allows rendering the complete document.
 */
class Document {
    // List to store all added elements in order
    private List<DocumentElement> documentElements = new ArrayList<>();

    // Adds a new DocumentElement (Text, Image, etc.) to the list
    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    // Combines the rendered output of all elements into a single string
    public String render() {
        StringBuilder result = new StringBuilder();

        // Iterate over each element and append its rendered output
        for (DocumentElement element : documentElements) {
            result.append(element.render());
        }

        return result.toString();  // Final combined string of the document
    }
}

/**
 * =========================
 * INTERFACE: Persistence
 * =========================
 * This interface represents different storage options for saving the document.
 * Allows future extension (e.g., save to DB, cloud, etc.)
 */
interface Persistence {
    void save(String data);  // Contract to save rendered document string
}

/**
 * =========================
 * CLASS: FileStorage
 * =========================
 * Implements saving the document to a file on local disk.
 */
class FileStorage implements Persistence {
    @Override
    public void save(String data) {
        try {
            // Create a FileWriter for "document.txt"
            FileWriter outFile = new FileWriter("document.txt");

            // Write document data to file
            outFile.write(data);

            // Close the file writer
            outFile.close();

            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            // If file cannot be written, print error message
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

/**
 * =========================
 * CLASS: DBStorage (Future Extension)
 * =========================
 * Placeholder for saving to a database instead of file.
 */
class DBStorage implements Persistence {
    @Override
    public void save(String data) {
        // Stub implementation: In real systems, connect to DB and persist the data
    }
}

/**
 * =========================
 * CLASS: DocumentEditor
 * =========================
 * This is the main controller for the client. Provides APIs to:
 * - Add content (text, image, tab, newline)
 * - Render the final document
 * - Save the document via selected storage method
 */
class DocumentEditor {
    private Document document;               // The document being edited
    private Persistence storage;             // Chosen storage type (file or db)
    private String renderedDocument = "";    // Caches final rendered string

    // Constructor receives a Document and a Persistence implementation
    public DocumentEditor(Document document, Persistence storage) {
        this.document = document;
        this.storage = storage;
    }

    // Adds a TextElement to the document
    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    // Adds an ImageElement to the document
    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    // Adds a NewLineElement (line break)
    public void addNewLine() {
        document.addElement(new NewLineElement());
    }

    // Adds a TabSpaceElement (indentation)
    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }

    // Renders the document to string. Renders only once and caches it.
    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            renderedDocument = document.render();  // Lazy rendering
        }
        return renderedDocument;
    }

    // Saves the final rendered document using the configured persistence mechanism
    public void saveDocument() {
        storage.save(renderDocument());  // Save the cached rendered document
    }
}

/**
 * =========================
 * CLASS: DocumentEditorClient
 * =========================
 * Demonstrates how a client or end-user would use the editor system.
 */
public class DocumentEditorClient {
    public static void main(String[] args) {
        // Step 1: Create a new blank document
        Document document = new Document();

        // Step 2: Choose the storage mechanism (File or DB)
        Persistence persistence = new FileStorage();  // Can switch to DBStorage

        // Step 3: Create a document editor instance with the above document & storage
        DocumentEditor editor = new DocumentEditor(document, persistence);

        // Step 4: Simulate a user creating a document by adding elements
        editor.addText("Hello, world!");                      // Add text
        editor.addNewLine();                                  // Add line break
        editor.addText("This is a real-world document editor example.");
        editor.addNewLine();                                  // Another line break
        editor.addTabSpace();                                 // Add tab (indent)
        editor.addText("Indented text after a tab space.");   // Add more text
        editor.addNewLine();                                  // Add another line
        editor.addImage("picture.jpg");                       // Add image

        // Step 5: Display the final rendered document to the console
        System.out.println(editor.renderDocument());

        // Step 6: Save the document to a file (or DB if using DBStorage)
        editor.saveDocument();
    }
}


//Pattern	               Explanation
//Strategy Pattern	      Persistence interface with FileStorage, DBStorage strategies
//Composite Pattern	      Document is composed of different DocumentElement objects
//Open/Closed Principle	  Easily extendable (e.g. add TableElement) without modifying core classes
//Single Responsibility	  Each class has only one job (e.g., Editor, Element, Storage, etc.)
//Interface Segregation	  Interfaces like DocumentElement, Persistence keep roles clean