package hiroshi.VisitorProblem;

import java.util.Iterator;

public class FileFindVisitor extends Visitor {
    private String extension;
    private String currentdir = "";

    public FileFindVisitor(String extension) {
        this.extension = extension;
    }

    public void visit(File file) {
        if (file.getName().contains(extension)) {
            System.out.println(file.getName() + " has " + extension);
        }
    }

    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
    }
}
