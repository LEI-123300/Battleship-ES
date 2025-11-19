# Battleship

Basic academic version of Battleship game to build upon.

Diagrama UML e javadoc disponiveis na diretoria /docs.

Membros do grupo:\
LEI-111633\
LEI-123281\
LEI-123280\
LEI-123300

C:.
│   .gitignore
│   pom.xml
│   README.md
│
├───.github
│   └───workflows
│           maven.yml
│
├───.idea
│   │   .gitignore
│   │   codeInsightSettings.xml
│   │   encodings.xml
│   │   misc.xml
│   │   vcs.xml
│   │
│   └───codeStyles
│           codeStyleConfig.xml
│
├───.mvn
│       jvm.config
│       maven.config
│
├───docs
│   │   DiagramaUML.png
│   │
│   └───javadoc
│       │   allclasses-index.html
│       │   allpackages-index.html
│       │   element-list
│       │   help-doc.html
│       │   index.html
│       │   member-search-index.js
│       │   module-search-index.js
│       │   overview-summary.html
│       │   overview-tree.html
│       │   package-search-index.js
│       │   search.html
│       │   tag-search-index.js
│       │   type-search-index.js
│       │
│       ├───index-files
│       │       index-1.html
│       │       index-10.html
│       │       index-11.html
│       │       index-12.html
│       │       index-13.html
│       │       index-14.html
│       │       index-15.html
│       │       index-16.html
│       │       index-17.html
│       │       index-2.html
│       │       index-3.html
│       │       index-4.html
│       │       index-5.html
│       │       index-6.html
│       │       index-7.html
│       │       index-8.html
│       │       index-9.html
│       │
│       ├───iscteiul
│       │   └───ista
│       │       │   App.html
│       │       │   package-summary.html
│       │       │   package-tree.html
│       │       │
│       │       └───battleship
│       │               Barge.html
│       │               Caravel.html
│       │               Carrack.html
│       │               Compass.html
│       │               Fleet.html
│       │               Frigate.html
│       │               Galleon.html
│       │               Game.html
│       │               IFleet.html
│       │               IGame.html
│       │               IPosition.html
│       │               IShip.html
│       │               package-summary.html
│       │               package-tree.html
│       │               Position.html
│       │               Ship.html
│       │               Tasks.html
│       │
│       ├───legal
│       │       ADDITIONAL_LICENSE_INFO
│       │       ASSEMBLY_EXCEPTION
│       │       dejavufonts.md
│       │       jquery.md
│       │       jqueryUI.md
│       │       LICENSE
│       │
│       ├───resource-files
│       │   │   copy.svg
│       │   │   glass.svg
│       │   │   jquery-ui.min.css
│       │   │   left.svg
│       │   │   link.svg
│       │   │   right.svg
│       │   │   stylesheet.css
│       │   │   x.svg
│       │   │
│       │   └───fonts
│       │           dejavu.css
│       │           DejaVuLGCSans-Bold.woff
│       │           DejaVuLGCSans-Bold.woff2
│       │           DejaVuLGCSans-BoldOblique.woff
│       │           DejaVuLGCSans-BoldOblique.woff2
│       │           DejaVuLGCSans-Oblique.woff
│       │           DejaVuLGCSans-Oblique.woff2
│       │           DejaVuLGCSans.woff
│       │           DejaVuLGCSans.woff2
│       │           DejaVuLGCSansMono-Bold.woff
│       │           DejaVuLGCSansMono-Bold.woff2
│       │           DejaVuLGCSansMono-BoldOblique.woff
│       │           DejaVuLGCSansMono-BoldOblique.woff2
│       │           DejaVuLGCSansMono-Oblique.woff
│       │           DejaVuLGCSansMono-Oblique.woff2
│       │           DejaVuLGCSansMono.woff
│       │           DejaVuLGCSansMono.woff2
│       │           DejaVuLGCSerif-Bold.woff
│       │           DejaVuLGCSerif-Bold.woff2
│       │           DejaVuLGCSerif-BoldItalic.woff
│       │           DejaVuLGCSerif-BoldItalic.woff2
│       │           DejaVuLGCSerif-Italic.woff
│       │           DejaVuLGCSerif-Italic.woff2
│       │           DejaVuLGCSerif.woff
│       │           DejaVuLGCSerif.woff2
│       │
│       └───script-files
│               jquery-3.7.1.min.js
│               jquery-ui.min.js
│               script.js
│               search-page.js
│               search.js
│
├───LEI-123280-report
│   │   index.html
│   │   index_SORT_BY_BLOCK.html
│   │   index_SORT_BY_BLOCK_DESC.html
│   │   index_SORT_BY_CLASS.html
│   │   index_SORT_BY_CLASS_DESC.html
│   │   index_SORT_BY_LINE.html
│   │   index_SORT_BY_LINE_DESC.html
│   │   index_SORT_BY_METHOD.html
│   │   index_SORT_BY_METHOD_DESC.html
│   │   index_SORT_BY_NAME_DESC.html
│   │
│   ├───css
│   │       coverage.css
│   │       idea.min.css
│   │
│   ├───img
│   │       arrowDown.gif
│   │       arrowUp.gif
│   │
│   ├───js
│   │       highlight.min.js
│   │       highlightjs-line-numbers.min.js
│   │
│   ├───ns-1
│   │   │   index.html
│   │   │   index_SORT_BY_BLOCK.html
│   │   │   index_SORT_BY_BLOCK_DESC.html
│   │   │   index_SORT_BY_CLASS.html
│   │   │   index_SORT_BY_CLASS_DESC.html
│   │   │   index_SORT_BY_LINE.html
│   │   │   index_SORT_BY_LINE_DESC.html
│   │   │   index_SORT_BY_METHOD.html
│   │   │   index_SORT_BY_METHOD_DESC.html
│   │   │   index_SORT_BY_NAME_DESC.html
│   │   │
│   │   └───sources
│   │           source-1.html
│   │
│   └───ns-2
│       │   index.html
│       │   index_SORT_BY_BLOCK.html
│       │   index_SORT_BY_BLOCK_DESC.html
│       │   index_SORT_BY_CLASS.html
│       │   index_SORT_BY_CLASS_DESC.html
│       │   index_SORT_BY_LINE.html
│       │   index_SORT_BY_LINE_DESC.html
│       │   index_SORT_BY_METHOD.html
│       │   index_SORT_BY_METHOD_DESC.html
│       │   index_SORT_BY_NAME_DESC.html
│       │
│       └───sources
│               source-1.html
│               source-2.html
│               source-3.html
│               source-4.html
│               source-5.html
│               source-6.html
│               source-7.html
│               source-8.html
│               source-9.html
│               source-a.html
│               source-b.html
│               source-c.html
│               source-d.html
│               source-e.html
│               source-f.html
│
├───reports
│   └───LEI-123300_report_testes_frota
│       │   index.html
│       │   index_SORT_BY_BLOCK.html
│       │   index_SORT_BY_BLOCK_DESC.html
│       │   index_SORT_BY_CLASS.html
│       │   index_SORT_BY_CLASS_DESC.html
│       │   index_SORT_BY_LINE.html
│       │   index_SORT_BY_LINE_DESC.html
│       │   index_SORT_BY_METHOD.html
│       │   index_SORT_BY_METHOD_DESC.html
│       │   index_SORT_BY_NAME_DESC.html
│       │
│       ├───css
│       │       coverage.css
│       │       idea.min.css
│       │
│       ├───img
│       │       arrowDown.gif
│       │       arrowUp.gif
│       │
│       ├───js
│       │       highlight.min.js
│       │       highlightjs-line-numbers.min.js
│       │
│       └───ns-1
│           │   index.html
│           │   index_SORT_BY_BLOCK.html
│           │   index_SORT_BY_BLOCK_DESC.html
│           │   index_SORT_BY_CLASS.html
│           │   index_SORT_BY_CLASS_DESC.html
│           │   index_SORT_BY_LINE.html
│           │   index_SORT_BY_LINE_DESC.html
│           │   index_SORT_BY_METHOD.html
│           │   index_SORT_BY_METHOD_DESC.html
│           │   index_SORT_BY_NAME_DESC.html
│           │
│           └───sources
│                   source-1.html
│                   source-2.html
│                   source-3.html
│                   source-4.html
│                   source-5.html
│                   source-6.html
│                   source-7.html
│                   source-8.html
│                   source-9.html
│                   source-a.html
│                   source-b.html
│                   source-c.html
│                   source-d.html
│                   source-e.html
│                   source-f.html
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───iscteiul
│   │   │       └───ista
│   │   │           │   App.java
│   │   │           │
│   │   │           └───battleship
│   │   │                   Barge.java
│   │   │                   Caravel.java
│   │   │                   Carrack.java
│   │   │                   Compass.java
│   │   │                   Fleet.java
│   │   │                   Frigate.java
│   │   │                   Galleon.java
│   │   │                   Game.java
│   │   │                   IFleet.java
│   │   │                   IGame.java
│   │   │                   IPosition.java
│   │   │                   IShip.java
│   │   │                   Position.java
│   │   │                   Ship.java
│   │   │                   Tasks.java
│   │   │
│   │   └───resources
│   │           log4j2.xml
│   │
│   ├───site
│   │       site.xml
│   │
│   └───test
│       └───java
│           └───iscteiul
│               └───ista
│                   │   AppTest.java
│                   │   PositionTest.java
│                   │   ShipTest.java
│                   │
│                   └───battleship
│                           BargeTest.java
│                           CaravelTest.java
│                           CarrackTest.java
│                           FleetTest.java
│
└───target
    ├───classes
    │   │   log4j2.xml
    │   │
    │   └───iscteiul
    │       └───ista
    │           │   App.class
    │           │
    │           └───battleship
    │                   Barge.class
    │                   Caravel.class
    │                   Carrack.class
    │                   Compass.class
    │                   Fleet.class
    │                   Frigate.class
    │                   Galleon.class
    │                   Game.class
    │                   IFleet.class
    │                   IGame.class
    │                   IPosition.class
    │                   IShip.class
    │                   Position.class
    │                   Ship.class
    │                   Tasks.class
    │
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    └───test-classes
        └───iscteiul
            └───ista
                │   AppTest.class
                │   PositionTest.class
                │   ShipTest$StubShip.class
                │   ShipTest.class
                │
                └───battleship
                        BargeTest.class
                        CaravelTest.class
                        CarrackTest.class
                        FleetTest.class