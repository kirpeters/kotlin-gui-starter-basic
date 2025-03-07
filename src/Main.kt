/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import java.awt.image.ColorModel
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var helloButton: JButton
    private lateinit var goodbyeButton: JButton
    private lateinit var textField: JTextField

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 400)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        greetingLabel = JLabel("Click a button...")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 50, 500, 50)
        greetingLabel.font = Font("Arial", Font.PLAIN, 24)
        add(greetingLabel)

        helloButton = JButton("hello!")
        helloButton.bounds = Rectangle(50,200,220,100)
        helloButton.addActionListener(this)     // Handle any clicks
        //helloButton.background = Color.BLUE
        //helloButton.foreground = Color.WHITE
        add(helloButton)
        goodbyeButton = JButton("goodbye!")
        goodbyeButton.bounds = Rectangle(330,200,220,100)
        goodbyeButton.addActionListener(this)     // Handle any clicks
        //goodbyeButton.background = Color.BLUE
        //goodbyeButton.foreground = Color.WHITE
        add(goodbyeButton)

        textField = JTextField()
        textField.bounds = Rectangle(50, 120, 500, 60)  // Position and size
        add(textField)
    }



    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        val userName = textField.text.trim()


        when (e?.source) {
            helloButton -> {
                if (userName.isNotEmpty()) {
                    greetingLabel.text = "Hello, $userName!"
                    greetingLabel.foreground = Color.GREEN
                } else {
                    greetingLabel.text = "Hello, stranger!"
                    greetingLabel.foreground = Color.GREEN
                }
            }
            goodbyeButton -> {
                if (userName.isNotEmpty()) {
                    greetingLabel.text = "Goodbye, $userName!"
                    greetingLabel.foreground = Color.RED
                } else {
                    greetingLabel.text = "Goodbye, stranger!"
                    greetingLabel.foreground = Color.RED
                }
            }
        }
    }

}

