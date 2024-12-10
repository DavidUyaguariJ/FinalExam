package ProyectGUI.AuthenticationGUI;

import javax.swing.*;
import java.awt.*;

class PanelConFondo extends JPanel {
    private Image imagenFondo;

    public PanelConFondo(String rutaImagen) {
        imagenFondo = new ImageIcon(rutaImagen).getImage();
        if (imagenFondo == null) {
            System.out.println("Error: Imagen no encontrada en " + rutaImagen);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
