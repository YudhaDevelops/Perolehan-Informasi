package tugas_akhir;
public class InvertexIndex {

    LinkedLIstOrderedUnique<Term> kamus;

    public InvertexIndex() {
        kamus = new LinkedLIstOrderedUnique();
    }

    public void search(String data) {
        this.kamus.search(data);
    }

    public void add(String term, String dokumen) {
        Term temp = new Term(term);
        temp.setNama(term);
        temp.addDokumen(dokumen);
        if (this.kamus.get(temp) == null) {
            //kalo data nya masih kosong
            this.kamus.addSort(temp);
        } else {
            //klk data dictionary nya dah ada //cari data nya
            Term data = this.kamus.get(temp);
            data.addDokumen(dokumen);
        }
    }

    public void searchDoc(String[] data) {
        if (data.length == 1) {
            Term temp = new Term(data[0]);
            Term hasil = this.kamus.get(temp);
            if (hasil != null) {
                LinkedLIstOrderedUnique hasilCari = hasil.getDokumen();
                System.out.print("Hasil : ");
                cetakHasil(hasilCari);
            } else {
                System.out.println("Data Yang Anda Cari Tidak Ada");
            }
        } else {
            LinkedLIstOrderedUnique<Term> dataBaru = new LinkedLIstOrderedUnique<>();
            for (int i = 0; i < data.length; i++) {
                Term temp = new Term(data[i]);
                Term hasil = this.kamus.get(temp);
                if (hasil != null) {
                    dataBaru.add(hasil);
                }
            }

            Term tempp = new Term();
            for (int i = 0; i < dataBaru.size() - 1; i++) {
                for (int j = 0; j < dataBaru.size() - 1; j++) {
                    if (dataBaru.get(j).getDokumen().size() > dataBaru.get(j + 1).getDokumen().size()) {
                        tempp = dataBaru.get(j);
                        dataBaru.set(j, dataBaru.get(j + 1));
                        dataBaru.set(j + 1, tempp);
                    }
                }
            }

            if (dataBaru.size() > 1) {
                LinkedLIstOrderedUnique docKamus1 = dataBaru.get(0).getDokumen();
                LinkedLIstOrderedUnique hasilOr = new LinkedLIstOrderedUnique();
                for (int i = 1; i < dataBaru.size(); i++) {
                    LinkedLIstOrderedUnique docKamus2 = dataBaru.get(i).getDokumen();
                    docKamus1 = intersec(docKamus1, docKamus2);
                }
                if (docKamus1.size() < 1) {
                    System.out.println("Query Tidak Di Temukan Untuk Hasil And \nPada Dokumen Manapun");
                } else {
                    System.out.print("Hasil And : ");
                    cetakHasil(docKamus1);
                }
                hasilOr = ProsesOr(dataBaru);
                System.out.print("Hasil Or : ");
                cetakHasil(hasilOr);
            }else{
                System.out.println("Query Tidak Di Temukan Untuk Hasil And \nPada Dokumen Manapun");
            }
        }
    }

    public void SearchData(String data) {
        String[] key = data.split(" ");

        if (key.length == 1) {
            Term temp = new Term(key[0]);
            Term hasil = this.kamus.get(temp);
            if (hasil != null) {
                LinkedLIstOrderedUnique hasilCari = hasil.getDokumen();
                cetakHasil(hasilCari);
            } else {
                System.out.println("Data Yang Anda Cari Tidak Ada");
            }
        } else {
            LinkedLIstOrderedUnique<Term> dataBaru = new LinkedLIstOrderedUnique<>();
            for (int i = 0; i < key.length; i++) {
                Term temp = new Term(key[i]);
                Term hasil = this.kamus.get(temp);
                if (hasil != null) {
                    dataBaru.add(hasil);
                } else {
                    System.out.println("Kata " + key[i] + " Tidak ada di dokumen mana pun");
                    System.out.println("Maaf Program Kami Hentikan");
                    System.exit(0);
                }
            }

            Term tempp = new Term();
            for (int i = 0; i < dataBaru.size() - 1; i++) {
                for (int j = 0; j < dataBaru.size() - 1; j++) {
                    if (dataBaru.get(j).getDokumen().size() > dataBaru.get(j + 1).getDokumen().size()) {
                        tempp = dataBaru.get(j);
                        dataBaru.set(j, dataBaru.get(j + 1));
                        dataBaru.set(j + 1, tempp);
                    }
                }
            }

            if (dataBaru.size() > 1) {
                LinkedLIstOrderedUnique docKamus1 = dataBaru.get(0).getDokumen();
                for (int i = 1; i < dataBaru.size(); i++) {
                    LinkedLIstOrderedUnique docKamus2 = dataBaru.get(i).getDokumen();
                    docKamus1 = intersec(docKamus1, docKamus2);
                }
                if (docKamus1.size() < 1) {
                    System.out.println("Query Tidak Di Temukan Di Dokumen Manapun");
                } else {
                    cetakHasil(docKamus1);
                }
            }
        }
    }

    public LinkedLIstOrderedUnique intersec(LinkedLIstOrderedUnique data1, LinkedLIstOrderedUnique data2) {
        LinkedLIstOrderedUnique temp = new LinkedLIstOrderedUnique();
        for (int i = 0; i < data2.size(); i++) {
            for (int j = 0; j < data1.size(); j++) {
                if (data2.get(i).equals(data1.get(j))) {
                    temp.add(data2.get(i));
                }
            }
        }
        return temp;
    }

    public void cetakHasil(LinkedLIstOrderedUnique data) {
        for (int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i) + ", ");
        }
        System.out.println("");
    }

    public LinkedLIstOrderedUnique ProsesOr(LinkedLIstOrderedUnique<Term> data) {
        LinkedLIstOrderedUnique temp = new LinkedLIstOrderedUnique();
        for (int i = 0; i < data.size(); i++) {
            LinkedLIstOrderedUnique docKamus = data.get(i).getDokumen();
            for (int j = 0; j < docKamus.size(); j++) {
                if (temp.contains(docKamus.get(j))) {
                    continue;
                } else {
                    temp.add(docKamus.get(j));
                }
            }
        }
        return temp;
    }
}
