package com.gomon.ui.components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class OTPTextField extends JTextField {

    private OTPTextField nextField;
    private OTPTextField previousField;

    private final Color normalBorder = new Color(210, 210, 210);

    private final Color focusBorder = new Color(0, 150, 136);

    private final Color errorBorder = new Color(220, 53, 69);

    private final Color successBorder = new Color(40, 167, 69);

    public OTPTextField() {

        initialize();

    }

    private void initialize() {

        setHorizontalAlignment(JTextField.CENTER);

        setFont(new Font("Segoe UI", Font.BOLD, 24));

        setPreferredSize(new Dimension(52, 55));

        setMaximumSize(new Dimension(52, 55));

        setCaretColor(new Color(0, 150, 136));

        setBackground(Color.WHITE);

        setBorder(createBorder(normalBorder));

        addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {

                setBorder(createBorder(focusBorder));

                selectAll();

            }

            @Override
            public void focusLost(FocusEvent e) {

                setBorder(createBorder(normalBorder));

            }

        });

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {

                    e.consume();

                    return;

                }

                if (getText().length() >= 1) {

                    setText("");

                }

            }

        });

        setTransferHandler(new TransferHandler() {

            @Override
            public boolean importData(TransferSupport support) {

                try {

                    if (!support.isDataFlavorSupported(
                            java.awt.datatransfer.DataFlavor.stringFlavor)) {

                        return false;
                    }

                    String text = (String) support.getTransferable()
                            .getTransferData(
                                    java.awt.datatransfer.DataFlavor.stringFlavor);

                    pasteOTP(text);

                    return true;

                } catch (Exception ex) {

                    ex.printStackTrace();

                    return false;

                }

            }

        });

    }

    private Border createBorder(Color color) {

        return BorderFactory.createCompoundBorder(

                new LineBorder(color, 2, true),

                BorderFactory.createEmptyBorder(5, 5, 5, 5)

        );

    }

    public void pasteOTP(String otp) {

        if (otp == null) {
            return;
        }

        otp = otp.replaceAll("\\D", "");

        OTPTextField current = this;

        for (int i = 0; i < otp.length() && current != null; i++) {

            current.setText(String.valueOf(otp.charAt(i)));

            current = current.nextField;
        }

        if (current == null) {
            return;
        }

        current.requestFieldFocus();

    }

    public void setNextField(OTPTextField nextField) {
        this.nextField = nextField;
    }

    public void setPreviousField(OTPTextField previousField) {
        this.previousField = previousField;
    }

    public String getDigit() {
        return getText().trim();
    }

    public void clearDigit() {
        setText("");
    }

    public void requestFieldFocus() {

        requestFocusInWindow();

        selectAll();

    }

    public void setError() {
        setBorder(createBorder(errorBorder));
    }

    public void setSuccess() {
        setBorder(createBorder(successBorder));
    }

    public void setNormal() {
        setBorder(createBorder(normalBorder));
    }

    public boolean isFilled() {
        return getText().trim().length() == 1;
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {

        super.processKeyEvent(e);

        if (e.getID() != KeyEvent.KEY_RELEASED)
            return;

        switch (e.getKeyCode()) {

            case KeyEvent.VK_0:
            case KeyEvent.VK_1:
            case KeyEvent.VK_2:
            case KeyEvent.VK_3:
            case KeyEvent.VK_4:
            case KeyEvent.VK_5:
            case KeyEvent.VK_6:
            case KeyEvent.VK_7:
            case KeyEvent.VK_8:
            case KeyEvent.VK_9:

                if (getText().length() == 1 && nextField != null) {

                    nextField.requestFieldFocus();

                }

                break;

            case KeyEvent.VK_BACK_SPACE:

                if (getText().isEmpty() && previousField != null) {

                    previousField.requestFieldFocus();

                }

                break;

            case KeyEvent.VK_LEFT:

                if (previousField != null) {

                    previousField.requestFieldFocus();

                }

                break;

            case KeyEvent.VK_RIGHT:

                if (nextField != null) {

                    nextField.requestFieldFocus();

                }

                break;

        }

    }
}
