import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingPerkuliahanGUI {
    static class Mahasiswa {
        String nama;
        String nim;

        Mahasiswa(String nama, String nim) {
            this.nama = nama;
            this.nim = nim;
        }
    }

    private JFrame frame; // frame utama
    private JTable table; // tabel untuk menampilkan data
    private DefaultTableModel tableModel; // model tabel untuk manipulasi data
    private JLabel sortingInfo; // untuk menampilkan metode sorting yang digunakan
    private Mahasiswa[] mahasiswa;

    public SortingPerkuliahanGUI() {
        frame = new JFrame("Sorting Mahasiswa FILKOM");
        frame.setSize(700, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // data Dummy untuk Testing
        mahasiswa = new Mahasiswa[]{
                new Mahasiswa("Budiono Siregar", "235150707111021"),
                new Mahasiswa("Ani Kumalasari", "235150707111190"),
                new Mahasiswa("Citra Lestari", "235150707111000")
        };

        // panel tombol diatas
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        JPanel buttonPanel = new JPanel();
        JButton sortByNIMButton = new JButton("Sort by NIM (Bubble Sort)");
        JButton sortByNameButton = new JButton("Sort by Name (Selection Sort)");
        buttonPanel.add(sortByNIMButton);
        buttonPanel.add(sortByNameButton);

        // label untuk metode sorting
        sortingInfo = new JLabel("Click a button to sort data.", SwingConstants.CENTER);
        sortingInfo.setFont(new Font("Arial", Font.BOLD, 14));
        sortingInfo.setForeground(Color.BLUE);

        topPanel.add(buttonPanel);
        topPanel.add(sortingInfo);
        frame.add(topPanel, BorderLayout.NORTH);

        // tabel untuk menampilkan data mahasiswa
        tableModel = new DefaultTableModel(new Object[]{"NIM", "Nama"}, 0);
        table = new JTable(tableModel);
        refreshTable();

        // scroll pane untuk tabel
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // footer
        JPanel bottomPanel = new JPanel();
        JLabel footerLabel = new JLabel("Developed by: Muhammad Naufal Farrel Azhra", SwingConstants.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        bottomPanel.add(footerLabel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // untuk tombol sorting
        sortByNIMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bubbleSortByNIM(mahasiswa);
                refreshTable();
                sortingInfo.setText("Data sorted using Bubble Sort by NIM.");
                JOptionPane.showMessageDialog(frame, "Data berhasil diurutkan menggunakan Bubble Sort berdasarkan NIM!");
            }
        });

        sortByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectionSortByName(mahasiswa);
                refreshTable();
                sortingInfo.setText("Data sorted using Selection Sort by Name.");
                JOptionPane.showMessageDialog(frame, "Data berhasil diurutkan menggunakan Selection Sort berdasarkan Nama!");
            }
        });

        frame.setVisible(true);
    }

    // bubble Sort untuk NIM
    private void bubbleSortByNIM(Mahasiswa[] mahasiswa) {
        int n = mahasiswa.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (mahasiswa[j].nim.compareTo(mahasiswa[j + 1].nim) > 0) {
                    Mahasiswa temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j + 1];
                    mahasiswa[j + 1] = temp;
                }
            }
        }
    }

    // selection Sort untuk Nama
    private void selectionSortByName(Mahasiswa[] mahasiswa) {
        int n = mahasiswa.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (mahasiswa[j].nama.compareTo(mahasiswa[minIndex].nama) < 0) {
                    minIndex = j;
                }
            }
            Mahasiswa temp = mahasiswa[minIndex];
            mahasiswa[minIndex] = mahasiswa[i];
            mahasiswa[i] = temp;
        }
    }

    // refresh data tabel
    private void refreshTable() {
        tableModel.setRowCount(0); // Hapus semua data di tabel
        for (Mahasiswa m : mahasiswa) {
            tableModel.addRow(new Object[]{m.nim, m.nama}); // Tambahkan data mahasiswa
        }
    }

    public static void main(String[] args) {
        new SortingPerkuliahanGUI();
    }
}
