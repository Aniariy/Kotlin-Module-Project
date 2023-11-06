import java.util.Scanner

class Archive (val name: String): hasItem<Note> {
    private var notes: ArrayList<Note> = ArrayList()

    override var nameItem: String = "заметку"
    fun newNote (note: Note) {
        notes.add(note)
    }
    fun delNote (note: Note) {
        notes.remove(note)
    }
    override fun getItems() : ArrayList<String>{
        var notesName: ArrayList<String> = ArrayList()
        for (note in notes) notesName.add(note.name)
        return notesName
    }

    override fun selectItem(index: Int) {
        var menu = Menu(notes[index])
        menu.start()
    }

    override fun addItem(name: String) {
       println("Введите текст заметки")
       var text = Scanner(System.`in`).nextLine()
       notes.add(Note(name, text))
    }

    override fun delItem(index: Int) {
        notes.removeAt(index)
    }

    fun getNote(index: Int): Note{
        return notes[index]
    }
}