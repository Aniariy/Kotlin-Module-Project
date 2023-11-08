import java.util.Scanner

class Note (val name: String, var text: String): HasItem<String>{
    override var nameItem: String = "текст"
    override fun getItems(): ArrayList<String> {
        val array: ArrayList<String> = ArrayList()
        array.add("Вывести текст заметки")
        return array
    }

    override fun selectItem(index: Int) {
        println(this.text)
        println(" ")
    }

    override fun addItem(t: String) {
        text += t
    }

    override fun delItem(index: Int) {
        text =""
    }


}