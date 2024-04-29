package hiroshi.VisitorProblem;

import java.util.ArrayList;
import java.util.Iterator;

public class FileFindVisitor extends Visitor {
    private String extension;
    private ArrayList found;

    public FileFindVisitor(String extension) {
        this.extension = extension;
        this.found = new ArrayList();
    }

    public void visit(File file) {
        if (file.getName().endsWith(extension)) {
            // System.out.println(file.getName() + " has " + extension);
            found.add(file);
        }
    }

    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
    }

    public Iterator getFoundIterator() {
        return found.iterator();
    }
}
