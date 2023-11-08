

import java.util.Scanner
class Menu< T, K: HasItem<T>> (private val mainItem: K){
    private var menuItems: ArrayList<String> = ArrayList()
    private val mainItemsCol: Int
    init {
        if (mainItem is Note) {
            menuItems.add("Добавить ${mainItem.nameItem}")
            mainItemsCol = 2
        }
            else {
            menuItems.add("Создать ${mainItem.nameItem}")
            menuItems.add("Удалить ${mainItem.nameItem}")
            mainItemsCol = 3
        }

        menuItems.addAll(mainItem.getItems())
    }
    private fun addItem (){
        if (mainItem is Note) println("Введите ${mainItem.nameItem}")
            else println("Введите имя ${mainItem.nameItem}")
        val name = Scanner(System.`in`).nextLine()
        if (name.isBlank()) {
            println("Некорректное имя")
            return
            }
        mainItem.addItem(name)
        if (!(mainItem is Note)) menuItems.add(name)
    }
    private fun delItem (){
        println("Введите номер пункта где находится удаляемая(ый) ${mainItem.nameItem}")
        val scanner = Scanner(System.`in`)
        if (!scanner.hasNextInt()) {
            println("Некорректное значение")
            return
        }
        val index = scanner.nextInt()
        if ((index < mainItemsCol) || (index > menuItems.size)) {
                println("Некорректное значение")
                return
            }
        mainItem.delItem(index-mainItemsCol)
        menuItems.removeAt(index-1)
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
       if ((index == 2)&&(!(mainItem is Note))) {
           delItem()
           return true
       }
       mainItem.selectItem(index-mainItemsCol)
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