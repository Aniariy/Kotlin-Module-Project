import java.util.Scanner

class Archive (val name: String): HasItem<Note> {
    private var notes: ArrayList<Note> = ArrayList()

    override var nameItem: String = "заметку"

    override fun getItems() : ArrayList<String>{
        val notesName: ArrayList<String> = ArrayList()
        for (note in notes) notesName.add(note.name)
        return notesName
    }

    override fun selectItem(index: Int) {
        val menu = Menu(notes[index])
        menu.start()
    }

    override fun addItem(name: String) {
       println("Введите текст заметки")
       val text = Scanner(System.`in`).nextLine()
       if (text.isBlank()) {
           println("Текст заметки пустой")
           return
       }
       notes.add(Note(name, text))
    }

    override fun delItem(index: Int) {
        notes.removeAt(index)
    }


}