# UniAlgorithmenProject--GraphenNetwerk-
Grahpen-Network programming. Second Semester Uni Project
Aufgabenstellung
Sie sind Teil eines Teams, das eine Software fuer die Verwaltung von Daten eines Kommunikationsnetzwerks erstellen soll. 
Neben dem Sammeln und Aufbereiten von Daten aus externen Quellen mu ̈ssen in diesem Programm Abfragen zur Netzwerkinfrastruktur implementiert werden.
Dazu muessen die Daten in einer geeigneten Datenstruktur abgelegt werden und darauf die Abfragen effizient ermoeglicht werden.


#Beschreibung
Das Netzwerk wird vereinfacht als Sammlung von Netzwerkknoten und den Verbindungen zwischen diesen Netzwerkknoten gesehen. Dabei gilt:
• Es wird am Anfang jedes Tests einer Instanz die Anzahl n der Knoten festgelegt. Diese Anzahl bleibt immer gleich, d.h. es werden keine neuen Knoten hinzugefuegt bzw. geloescht. Es wird angenommen, dass n > 0 ist.
• Die Netzwerkknoten werden von 0 beginnend bis n − 1 durchnummeriert.
• Zwischen zwei Netzwerkknoten kann eine Verbindung bestehen, ueber die Daten aus- getauscht werden. Die Daten ko ̈nnen in beide Richtungen fließen. Fuer die Loesung der Aufgaben ist die Richtung nicht von Bedeutung.
• Ein Knoten hat keine Verbindung zu sich selbst (Schleife).
• Die erwarteten Netzwerke sind du ̈nn besetzt.
Ihre Aufgabe besteht aus zwei Teilen. Einerseits muessen Sie eine passende Datenstruktur fuer das Speichern der Daten implementieren. Andererseits mu ̈ssen Sie folgende Operationen auf dieser Datenstruktur unterstuetzen:
• int numberOfNodes(): Liefert die Anzahl der Knoten zurueck.
• int numberOfConnections(): Liefert die Anzahl der Verbindungen zurueck.
• void addConnection(int v, int w): Fu ̈gt eine Verbindung im Netzwerk zwischen den Knoten v und w ein.
Ist diese Verbindung schon vorhanden, dann passiert nichts, d.h. die Verbindung bleibt im Netzwerk erhalten.
• void addAllConnections(int v): Fu ̈gt Verbindungen von einem bestimmten Knoten v zu allen anderen Knoten ein. Hatte der Knoten schon Verbindungen, dann bleiben diese erhalten.
• void deleteConnection(int v, int w): Entfernt eine Verbindung zwischen den Knoten v und w aus dem Netzwerk. Ist die Verbindung nicht vorhanden, dann passiert nichts.
• void deleteAllConnections(int v): Entfernt alle Verbindungen fu ̈r einen bestimmten Knoten v aus dem Netzwerk. Hatte der Knoten noch keine Verbindungen, dann passiert nichts.
• int numberOfComponents(): Liefert die Anzahl der Zusammenhangskomponen- ten im Netzwerk zuru ̈ck.
•booleanhasCycle():U ̈berpru ̈ft,obdasNetzwerkeinenKreisentha ̈lt.Wenndies der Fall ist, wird true zuru ̈ckgeliefert, ansonsten false.
• int minimalNumberOfConnections(int start, int end): Liefert die kleinste Anzahl an Verbindungen, die durchlaufen werden muss, um von einem Startknoten start zu einem Endknoten end zu gelangen. Sind start und end gleich, dann soll 0 zuru ̈ckgeliefert werden. Sind start und end nicht u ̈ber einen Pfad miteinander verbunden, dann wird -1 zuru ̈ckgeliefert.
• List<Integer> criticalNodes(): Liefert eine Liste jener Knoten zuru ̈ck, die als kritisch eingestuft werden. Ein Knoten ist kritisch, wenn das Entfernen aller Verbindungen zu diesem Knoten nicht nur diesen Knoten isoliert, sondern auch seine urspru ̈ngliche Zusammenhangskomponente in drei oder mehr Zusammenhangskom- ponenten zerfallen la ̈sst.


#Bitte beachten Sie noch folgende Hinweise zur Implementierung:
• Sie du ̈rfen fu ̈r die Datenhaltung (Speicherung der Knoten und Verbindungen) Java- Datenstrukturen verwenden.
• Alleobenangefu ̈hrtenMethodenmu ̈ssenvonIhnenselbsta ̈ndigimplementiertwerden. Die Funktionalita ̈t darf nicht durch Aufruf von Methoden in Bibliotheken realisiert werden.
• Siedu ̈rfenweitereHilfsmethodenimplementieren,derTestcodewirdabernurdieoben genannten Methoden aufrufen und auf Korrektheit testen.
• Sie du ̈rfen selbst entscheiden, ob Sie Ihre Methoden rekursiv oder iterativ implementieren.
• Achten Sie generell auf eine mo ̈glichst effiziente Implementierung (bezu ̈glich Laufzeit und zusa ̈tzlich erforderlichen Speicherplatzes).
