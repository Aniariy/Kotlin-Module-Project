

import java.util.Scanner
class Menu< T, K: hasItem<T>> (private var mainItem: K){
    private var menuItems: ArrayList<String> = ArrayList()
    init {
        menuItems.add("Создать ${mainItem.nameItem}")
        menuItems.add("Удалить ${mainItem.nameItem}")
        menuItems.addAll(mainItem.getItems())
    }
    private fun addItem (){
        println("Введите имя ${mainItem.nameItem}")
        val name = Scanner(System.`in`).nextLine()
        if (name == "") {
            println("Некорректное имя")
            return
            }
        mainItem.addItem(name)
        menuItems.add(name)
    }
    private fun delItem (){
        println("Введите номер пункта где находится удаляемая(ый) ${mainItem.nameItem}")
        val scanner = Scanner(System.`in`)
        if (!scanner.hasNextInt()) {
            println("Некорректное значение")
            return
        }
        val index = scanner.nextInt()
        if ((index < 3) || (index > menuItems.size)) {
                println("Некорректное значение")
                return
            }
        mainItem.delItem(index-3)
        menuItems.removeAt(index)
    }

    private fun selectItem(index: Int): Boolean{
       if (index > menuItems.size || index < 0) {
           println("Некорректный ввод. Номер отсутствует в списке")
           return true
       }
       if (index == 0) return false
       if (index == 1) {
           addItem()
           return true
       }
       if (index == 2) {
           delItem()
           return true
       }
       mainItem.selectItem(index-3)
       return true
    }

    private fun printItems(){
       println("Выберите пункт из списка (номер):")
       var index = 1
        for (item in menuItems) {
            println("$index: ${item}")
            index++
        }
        println("0: Выход")
    }

    fun start(){
      printItems()
      var index = -1
      while (true) {
          val scanner = Scanner(System.`in`)
          if (!scanner.hasNextInt()) {
              println("Некорректный ввод")
              continue
          }
          else {
              index = scanner.nextInt()
          }
          if (!selectItem(index)) return
          else printItems()
        }
      }

}