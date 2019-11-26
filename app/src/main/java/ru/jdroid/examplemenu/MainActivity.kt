package ru.jdroid.examplemenu

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // lateinit позволяет не инициализировать null`ом
    private lateinit var rootLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // находим наше view через его id (получаем объект LinearLayout)
        rootLayout = findViewById(R.id.root_screen)
    }

    // этот метод вызывается в Activity при старте приложения (создаёт меню)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // раздуваем (парсим) из .xml в объект наш меню файл и крепим этот объект на menu из аргументов...
        menuInflater.inflate(R.menu.head_menu, menu)
        Toast.makeText(this, "Attach", Toast.LENGTH_SHORT).show()
        return true
    }


    // этот метод вызывается в Activity, когда мы нажимаем на один из элементов меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // будем определять какой элемент пришёл по его id
        // через оператор when (аналог switch case в java)

        when (item.itemId) {
            // при нажатии на настройки выйдет всплывающее сообщение внизу
            R.id.m_settings ->
                Toast.makeText(this, "Open settings...", Toast.LENGTH_SHORT).show()
            // при нажатии на sub`меню primary перекрасим корневой layout в соотвествующий цвет...
            R.id.m_primary -> rootLayout.setBackgroundResource(R.color.colorPrimary)
            // аналогично ..
            R.id.m_accent -> rootLayout.setBackgroundResource(R.color.colorAccent)
            // возвращаем исходный цвет и выводим сообщение
            R.id.m_clear -> {

                rootLayout.setBackgroundColor(Color.WHITE)
                Toast.makeText(this, "Default returned", Toast.LENGTH_SHORT).show()

            }
        }
        return true
    }
}
