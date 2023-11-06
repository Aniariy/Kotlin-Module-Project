import java.util.Scanner

class Note (var name: String, var text: String): hasItem<String>{
    override var nameItem: String = "текст"
    override fun getItems(): ArrayList<String> {
        var array: ArrayList<String> = ArrayList()
        array.add("Вывести текст заметки")
        return array
    }

    override fun selectItem(index: Int) {
        println(this.text)
        println(" ")
    }

    override fun addItem(t: String) {
        text = t
    }

    override fun delItem(index: Int) {
        text =""
    }


}