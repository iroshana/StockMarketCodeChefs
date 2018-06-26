# Stock Market Game
# CodeChefs
 
 >Members
 <ul>
 <li>16211138       R I Athapattu</li>
 <li>16211200       T D Perera</li>
 <li>16211217       L K Weerasinghe</li>
 <li>16211238       V O Fernando</li>
 <li>16211133       S J Athukorala</li>
 </ul>

## Server Side Configuration

Need to Install
<ul>
<li>JDK 1.8 or higher</li>
<li>Wampserver</li>
<li>MySql</li>
<li>Apache Maven 3.5.3 or higher</li>
</ul>

Maven Configuration Follow this link - https://www.mkyong.com/maven/how-to-install-maven-in-windows/ <br />
Download Maven Link - http://maven.apache.org/download.cgi

create a new Database. Database Name is 'stockmarket'. <br />
Then run script 'stockmarket.sql' file in document Folder.

Open the Netbean IDE and open the project StockMarketGame in .../StockMarketGameServerSide/ <br />
Then Project right click and click the Build with Dependencies <br />
Finally project right click and click the Run.

## Client Side Configuration

Need to Install
<ul>
<li>Node js version 8.11.1 or higher</li>
<li>Vue js version 2.5.2 or higher</li>
</ul>

please use Node.js Command Prompt <br />
clone git project and go to the .../StockMarketGameClientSide/stockmarketgameclient/

1. npm install
2. npm run dev

open the browser and go to the link = http://localhost:8070

> A Vue.js project

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8070
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report

# run unit tests
npm run unit

# run all tests
npm test
```