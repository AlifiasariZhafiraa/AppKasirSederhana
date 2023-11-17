package bp;
import java.util.Scanner;

public class finalProject {
    //method mencari barang
    static int cariBarang(String[] brg, int[] harga, String cari){
        int barangKetemu = brg.length;
        boolean ketemu = false;
        
        for (int i = 0; i < brg.length; i++) {
            if (brg[i].equals(cari)){
                ketemu = true;
                System.out.println("  Barang Ditemukan");
                System.out.println("  " + brg[i] + "\tRp. " + harga[i]);
                barangKetemu = i;
            }
        }        
        if (ketemu == false){
            System.out.println("Barang Tidak Ada");
        }        
        return barangKetemu;
    }
    
    //method menambah barang
    static String[] tambahBarang(String[] brg, String barangBaru){
        String hasilTambah[] = new String[brg.length + 1] ;
        
        for (int i = 0; i < brg.length; i++){
            hasilTambah[i] = brg[i];
        }        
        hasilTambah[brg.length] = barangBaru;
        return hasilTambah;
    }
    
    //method menambah harga
    static int[] tambahHarga(int[] harga, int hargaBaru){
        int hasilTambah[] = new int[harga.length + 1];
        
        for (int i = 0; i < harga.length; i++) {
            hasilTambah[i] = harga[i];            
        }
        hasilTambah[harga.length] = hargaBaru;
        return hasilTambah;
    }
    
    //method menghapus barang
    static String[] hapusBarang(String[] brg, int indexHapus) {
        String hasilHapus[] = new String[brg.length - 1];
        
        for (int i = 0, barangBaru = 0; i < brg.length; i++) {
            if(indexHapus != i){
              hasilHapus[barangBaru++] = brg[i];
            }
        }

        return hasilHapus;
    }
    
    //method menghapus harga
    static int[] hapusHarga(int[] harga, int indexHapus) {
         int hasilHapus[] = new int[harga.length - 1];
        
        for (int i = 0, barangBaru = 0; i < harga.length; i++) {
            if(indexHapus != i){
               hasilHapus[barangBaru++] = harga[i];
            }
        }

        return hasilHapus;
    }  
    
    //method melihat barang terlaris
    static void barangTerlaris(String[] brg, int[] dataHarga, int[]  terlaris){
        int tempInt;
        String tempString;
        for (int i = 0; i < brg.length - 1; i++) {
            if(terlaris[i] < terlaris[i+1]){
                tempInt = terlaris[i];
                terlaris[i] = terlaris[i+1];
                terlaris[i+1] = tempInt;
                tempInt = dataHarga[i];
                dataHarga[i] = dataHarga[i+1];
                dataHarga[i+1] = tempInt;
                tempString = brg[i];
                brg[i] = brg[i+1];
                brg[i+1] = tempString;
            }
        }
        for (int i = 0; i < brg.length; i++) {
            System.out.println((i+1) + ". " + brg[i] + "\t Rp " + dataHarga[i] + "\t terjual " + terlaris[i] + "x");
        }
    }
    
    //method main
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String brg[] = {"KopiKaramel", 
            "TaroSeaweed", "KitkatMatcha", 
            "PejoyCoklat", "ChitatoBBQ"};
        int harga[] = { 10900, 12500, 12000, 10200, 11300};
        int terlaris[] = {0,0,0,0,0};
        String laporan[] = {};
        String cari = " ",
                dataBaru;
        int barangKetemu = brg.length,
            jumlahBeli = 0,
            totalBayar = 0,
            pembayaran = 0,                
            kembalian = 0,
            hargaBaru = 0;                
        
        System.out.println("================================================");
        System.out.println("                 Selamat Datang                 ");
        System.out.println("            → INDOMARET TENGGILIS ←            ");       
        int pilihRole = 0;
        do{
            System.out.println("\n================================================");
            System.out.println("                 Pilih Role Anda                ");
            System.out.println("================================================");
            System.out.println("1. Admin");
            System.out.println("2. Kasir");
            System.out.println("3. Owner");
            System.out.println("4. Selesai");
            System.out.print("\nPilih \t: ");
            pilihRole = scan.nextInt();
            switch (pilihRole){
                case 1: //Role Admin
                    int pilihAdmin = 0;
                    do{
                        System.out.println("\n  ------------------------------------------------");
                        System.out.println("                      Menu ADMIN                  ");
                        System.out.println("  ------------------------------------------------"); 
                        System.out.println("  1. Tampilkan Barang");
                        System.out.println("  2. Tambah Barang");
                        System.out.println("  3. Update Barang");
                        System.out.println("  4. Hapus Barang");
                        System.out.println("  5. Kembali");
                        System.out.print("\n  Pilih \t: ");
                        pilihAdmin = scan.nextInt();
                        System.out.println(" ");
                        
                        switch (pilihAdmin){
                            case 1: //Menampilkan Barang
                                System.out.println("\n  ------------------------------------------------");
                                System.out.println("                    Daftar BARANG                "); 
                                System.out.println("  ------------------------------------------------");
                                System.out.println("  NO\tNAMA BARANG\t HARGA");
                                System.out.println("  ______________________________");
                                for (int i = 0; i < brg.length; i++) {                                    
                                    System.out.print("  " + (i+1) + ".\t");
                                    System.out.print(brg[i] + "\tRp. ");
                                    System.out.println(harga[i] + " ");
                                }
                                break;
                            case 2: //Menambah Barang
                                System.out.println("\n  ------------------------------------------------");
                                System.out.println("                    Daftar BARANG                "); 
                                System.out.println("  ------------------------------------------------");
                                System.out.println("  NO\tNAMA BARANG\t HARGA");
                                System.out.println("  ______________________________");
                                for (int i = 0; i < brg.length; i++) {                                    
                                    System.out.println("  " + (i+1) + ".\t" + brg[i] + "\t Rp. " + harga[i]);
                                }
                                System.out.print("\n  Masukkan Nama Barang \t\t: ");
                                dataBaru = scan.next();
                                System.out.print("  Masukkan Harga Barang \t: ");
                                hargaBaru = scan.nextInt();
                                brg = tambahBarang(brg, dataBaru);
                                harga = tambahHarga(harga, hargaBaru);
                                System.out.println("\n  Barang Berhasil Ditambahkan");                                                                
                                break;
                            case 3: //Mengupdate Barang
                                System.out.println("\n  ------------------------------------------------");
                                System.out.println("                    Daftar BARANG                "); 
                                System.out.println("  ------------------------------------------------");
                                System.out.println("  NO\tNAMA BARANG\t HARGA");
                                System.out.println("  ______________________________");
                                for (int i = 0; i < brg.length; i++) {                                    
                                    System.out.println("  " + (i+1) + ".\t" + brg[i] + "\t Rp. " + harga[i]);
                                }
                                System.out.print("\n  Cari Barang Untuk Diupdate \t: ");
                                cari = scan.next();
                                System.out.println("");
                                barangKetemu = cariBarang(brg, harga, cari);
                                if(barangKetemu < brg.length){
                                    System.out.print("\n  Masukkan Update Nama Barang \t: ");
                                    brg[barangKetemu] = scan.next();
                                    System.out.print("  Masukkan Update Harga Barang \t: ");
                                    harga[barangKetemu] = scan.nextInt();
                                    System.out.println("\n  Barang Berhasil Diupdate");
                                }                                   
                                break;
                            case 4: //Menghapus Barang
                                System.out.println("\n  ------------------------------------------------");
                                System.out.println("                    Daftar BARANG                "); 
                                System.out.println("  ------------------------------------------------");
                                System.out.println("  NO\tNAMA BARANG\t HARGA");
                                System.out.println("  ______________________________");
                                for (int i = 0; i < brg.length; i++) {                                    
                                    System.out.println("  " + (i+1) + ".\t" + brg[i] + "\t Rp. " + harga[i]);
                                }
                                System.out.print("\n  Cari Barang Untuk Dihapus \t: ");
                                cari = scan.next();
                                System.out.println("");
                                barangKetemu = cariBarang(brg, harga, cari);
                                if(barangKetemu < brg.length){
                                    brg = hapusBarang(brg, barangKetemu);
                                    harga = hapusHarga(harga, barangKetemu);
                                    System.out.println("");
                                    System.out.println("  Barang Berhasil Dihapus");
                                }
                                break;
                            case 5:
                                System.out.println("  ← Kembali ");
                                break;
                            default:
                                System.out.println("  Pilihan Tidak Ada");
                        }
                    }while (pilihAdmin != 5);
                    break;
                case 2: //Role Kasir
                    int pilihKasir = 0;                    
                    do{
                        System.out.println("\n  ------------------------------------------------");
                        System.out.println("                      Menu KASIR                  ");
                        System.out.println("  ------------------------------------------------"); 
                        System.out.println("  1. Tambah Transaksi");
                        System.out.println("  2. Bayar");
                        System.out.println("  3. Kembali");
                        System.out.print("\n  Pilih \t: ");
                        pilihKasir = scan.nextInt();
                        System.out.println(" ");
                        
                        switch(pilihKasir){
                            case 1: //menambah transaksi
                                System.out.println("  NO\tNAMA BARANG\t HARGA");
                                System.out.println("  ______________________________");
                                for (int i = 0; i < brg.length; i++) {                                    
                                    System.out.println("  " + (i+1) + ".\t" + brg[i] + "\t Rp. " + harga[i]);
                                }
                                System.out.print("\n  Cari Barang Yang Akan Dibeli \t: ");
                                cari = scan.next();
                                System.out.println("");
                                barangKetemu = cariBarang(brg, harga, cari);
                                if(barangKetemu < brg.length){
                                    System.out.print("\n  Masukkan Jumlah Pembelian \t: ");
                                    jumlahBeli = scan.nextInt();
                                    totalBayar += harga[barangKetemu] * jumlahBeli;
                                    System.out.println("\n  Pembelian Berhasil Ditambahkan");
                                    System.out.println("");                                       
                                }                                                                                          
                                break;
                            case 2: //pembayaran       
                                System.out.println("  Total Bayar \t\t: Rp. " + totalBayar);
                                System.out.print("  Pembayaran \t\t: Rp. ");
                                pembayaran = scan.nextInt();
                                if(pembayaran < totalBayar){
                                    System.out.println("  Uang Pembayaran Kurang");
                                }else{
                                    kembalian = pembayaran - totalBayar;
                                    if(kembalian > 0){
                                        System.out.println("  Kembalian Anda \t: Rp. " + kembalian);
                                    }else{
                                        System.out.println("  Uang Anda Pas");
                                    }
                                    
                                    laporan = tambahBarang(laporan, " Total Bayar Rp. " + totalBayar + "\tPembayaran Rp. " + pembayaran);
                                    totalBayar = 0;
                                }
                                break;
                            case 3:
                                System.out.println("  ← Kembali ");
                                break;
                            default:
                                System.out.println("  Pilihan Tidak Ada");
                        }
                    }while(pilihKasir!=3);
                    break;
                case 3: //Role Owner
                    int pilihOwner = 0;
                    do{
                        System.out.println("\n  ------------------------------------------------");
                        System.out.println("                      Menu OWNER                  ");
                        System.out.println("  ------------------------------------------------"); 
                        System.out.println("  1. Lihat Transaksi");
                        System.out.println("  2. Barang Terlaris");
                        System.out.println("  3. Kembali");
                        System.out.print("\n  Pilih \t: ");
                        pilihOwner = scan.nextInt();
                        
                        switch (pilihOwner){
                            case 1: //melihat transaksi
                                System.out.println("\n  ------------------------------------------------");
                                System.out.println("                       Transaksi                  ");
                                System.out.println("  ------------------------------------------------"); 
                                if(laporan.length > 0){
                                    for (int i = 0; i < laporan.length; i++) {
                                        System.out.println("  " + (i+1) + ". " + laporan[i]);
                                    }
                                }else{
                                    System.out.println("  Transaksi Belum Dilakukan");
                                }
                                break;
                            case 2: //melihat barang terlaris
                                System.out.println("\n  ------------------------------------------------");
                                System.out.println("                   Barang terlaris                ");
                                System.out.println("  ------------------------------------------------"); 
                                barangTerlaris(brg, harga, terlaris);
                                break;
                            case 3:
                                System.out.println("  ← Kembali ");
                                break;
                            default:
                                System.out.println("  Pilihan Tidak Ada");
                        }
                    }while(pilihOwner!=3);
                    break;
                case 4:
                    System.out.println("================================================");
                    System.out.println("                   TERIMA KASIH                 ");
                    System.out.println("================================================");
                    break;
                default:
                    System.out.println("Pilihan Tidak Ada!");
            }
        }while(pilihRole!=4);
    }
}