interface HasItem<T> {
    var nameItem: String
    fun getItems():ArrayList<String>
    fun selectItem(index: Int)
    fun addItem(name: String)
    fun delItem(index: Int)

}