#!/bin/bash
# -*- coding: UTF8 -*-
cd BibliothequeUML
javadoc -d ../documentation eltGraphique/*.java eltGraphique/classe/*.java eltGraphique/ligne/*.java diagramme/*.java -charset utf8 -windowtitle "Bibliotheque UML" > ../javadoc.log 2>&1 
cd ..
