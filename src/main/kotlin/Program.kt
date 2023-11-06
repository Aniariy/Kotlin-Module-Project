class Program : hasItem<Archive>{
    var archives: ArrayList<Archive> = ArrayList()
    override var nameItem: String = "архив"

    override fun getItems(): ArrayList<String> {
        var notesName: ArrayList<String> = ArrayList()
        for (note in archives) notesName.add(note.name)
        return notesName
    }

    override fun selectItem(index: Int) {
      var menu = Menu(archives[index])
      menu.start()
    }

    override fun addItem(name: String) {
        archives.add(Archive(name))
    }

    override fun delItem(index: Int) {
        archives.removeAt(index)
    }
}