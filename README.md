# Warehouse inventory system

## Timurs Kvačovs | Ksenija Lakotko
##         DP2-4 audzēkņi

## 📝 Ievads

Mūsu proekts ir konsoles balstīta Java lietotne, kas paredzēta inventāra pārvaldībai. Programmas mērķis ir vienkāršot produktu pievienošanu, attēlošanu, filtrēšanu, kārtošanu, eksportēšanu un dzēšanu noliktavā. Tā nodrošina vienkāršu izvēlnes balstītu lietotāja saskarni tieši terminālī.

### 🔑 Galvenās iespējas:
- Jaunu produktu pievienošana.
- Visu produktu attēlošana formatētā tabulā.
- Produktu filtrēšana pēc kategorijas.
- Produktu kārtošana pēc nosaukuma, cenas, daudzuma vai piegādātāja.
- Kopējās inventāra vērtības aprēķins.
- Noliktavas noslodzes un brīvās vietas attēlošana.
- Datu eksportēšana uz CSV failu ar lietotāja norādītu nosaukumu.
- Produktu dzēšana pēc nosaukuma.
- Sveiciena un noslēguma animācijas.

---

## 🖥️ Lietotāja saskarne

### Galvenais logs (Izvēlne):
Pēc palaišanas programma parāda sveiciena animāciju un galveno izvēlni:

=== Warehouse management menu ===
1. Add product
2. Show all products
3. Category Filter
4. Sort products
5. Count all product cost
6. Show capacity/empty space
7. Export data to CSV
8. Remove product
0. Exit
Choose the action (0-8):

Katrs punkts atbilst konkrētai funkcijai:

- **1. Add product** – Pievieno jaunu produktu.
- **2. Show all products** – Parāda esošo inventāru tabulas veidā.
- **3. Category Filter** – Filtrē un izvāda produktus pēc izvēlētās kategorijas.
- **4. Sort products** – Kārto produktus pēc:
  - Nosaukuma (A-Z)
  - Cenas
  - Daudzuma
  - Piegādātāja
- **5. Count all product cost** – Parāda visu produktu kopējo vērtību.
- **6. Show capacity/empty space** – Rāda, cik vietas noliktavā ir izmantots un cik palicis.
- **7. Export data to CSV** – Saglabā datus CSV failā ar norādītu nosaukumu.
- **8. Remove product** – Dzēš produktu pēc nosaukuma.
- **0. Exit** – Iziet no programmas ar atvadu animāciju.

---

## ⚙️ Funkciju ceļvedis

### ✅ Produkta pievienošana:
1. Izvēlies `1`.
2. Ievadi informāciju: nosaukums, kategorija, piegādātājs, cena, daudzums.
3. Ja ir pietiekami vietas, produkts tiek pievienots.

### 📋 Visu produktu skatīšana:
1. Izvēlies `2`.
2. Tiks attēlota visu produktu tabula ar detaļām.

### 🔍 Filtrēšana pēc kategorijas:
1. Izvēlies `3`.
2. Ievadi kategorijas nosaukumu.
3. Tiks parādīti tikai attiecīgās kategorijas produkti.

### ↕️ Produktu kārtošana:
1. Izvēlies `4`.
2. Izvēlies kritēriju:
   - Nosaukums (A-Z)
   - Cena (augošā vai dilstošā secībā)
   - Daudzums
   - Piegādātājs (A-Z)

### 💰 Kopējās vērtības aprēķins:
1. Izvēlies `5`.
2. Tiek aprēķināta visu produktu kopējā vērtība (cena × daudzums).

### 📊 Noliktavas ietilpība:
1. Izvēlies `6`.
2. Parāda kopējo ietilpību un pieejamo vietu.

### 💾 Eksportēšana uz CSV:
1. Izvēlies `7`.
2. Ievadi faila nosaukumu.
3. Dati tiek saglabāti .csv failā.

### 🗑️ Produkta dzēšana:
1. Izvēlies `8`.
2. Ievadi produkta nosaukumu.
3. Ja produkts pastāv, tas tiek dzēsts.

---
 
