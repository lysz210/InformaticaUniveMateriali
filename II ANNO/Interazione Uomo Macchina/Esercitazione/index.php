<!doctype html>
<html>
<head>

<title>SosLibrary: Tutorial X3DOM</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

<!--Risorse per Mondo interattivo-->
<script type="text/javascript" src="js/Update.js"> </script>
<script type="text/javascript" src="js/Setup.js"> </script>
<script type="text/javascript" src="js/Utils.js"> </script>
<script type="text/javascript" src="js/SosLibrary.js"></script>
<script type="text/javascript" src="js/jquery-1.5.min.js" > </script>
<link rel="stylesheet" type="text/css" href="js/x3dom.css" />
<link href="styles/tutorial.css" rel="stylesheet" type="text/css" />

<style>
.infoDiv
{
display:none; position:absolute;
            padding: 5px;
            z-index: 1;
            width: 620px;
            bottom: 20px;
            left: 202px;
            border: 1px solid #000;
            color: #000; 
            background-color:#f4f9fe;
}
</style>
</head>

<body>

<div id="top"></div>

<h1>Tutorial X3DOM:</h1>

<div class="helpmenudiv" id="Intro">

<h2> Tutorial Interattivo</h2>
       
<X3D xmlns="http://www.web3d.org/specifications/x3d-namespace" showStat='false' showLog='false' width="1024px" height="600px" style="border: 0;">

		<div id="infoInnovazione" class="infoDiv">  
                <b>Innovazione:</b>
				<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                <p>Indice di Innovazione: <b><span id="valoreInnovazione"></span>%</b></p>
                
                <input type="button" value="Chiudi" onclick="$('.infoDiv').hide();" />
		</div>
        
        <div id="infoGovernance" class="infoDiv">  
                <b>Governance:</b>
				<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                <p>Media Voti: <b><span id="valoreGovernance"></span> / 10</b></p>
                
                <input type="button" value="Chiudi" onclick="$('.infoDiv').hide();" />
		</div>
        
        <div id="infoPersonale" class="infoDiv">  
                <b>Politiche per il Personale:</b>
				<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                <p>Ore di telelavoro / part time (in % sul totale): <b><span id="valorePersonale"></span>%</b></p>
                
                <input type="button" value="Chiudi" onclick="$('.infoDiv').hide();" />
		</div>
        
        <div id="infoStudenti" class="infoDiv">  
                <b>Politiche per gli Studenti:</b>
				<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                <p>Media Voti: <b><span id="valoreStudenti"></span> / 10</b></p>
                
                <input type="button" value="Chiudi" onclick="$('.infoDiv').hide();" />
		</div>
        
        <div id="infoMateriali" class="infoDiv">  
                <b>Materiali:</b>
				<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                <p>Documenti Digitali (in % sul totale): <b><span id="valoreMateriali"></span>%</b></p>
                
                <input type="button" value="Chiudi" onclick="$('.infoDiv').hide();" />
		</div>
        
        <div id="infoEnergia" class="infoDiv">  
                <b>Energia:</b>
				<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                <p>Consumi Elettrici: <b><span id="valoreEnergia"></span> KW/h</b></p>
                
                <input type="button" value="Chiudi" onclick="$('.infoDiv').hide();" />
        </div>
        
        <div id="infoAcqua" class="infoDiv">  
                <b>Acqua:</b>
				<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                 ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
                  occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                <p>Media consumo d'acqua mensile: <b><span id="valoreAcqua"></span> m3/m2</b></p>
                
                <input type="button" value="Chiudi" onclick="$('.infoDiv').hide();" />
		</div>
                
        <div id="infoRifiuti" class="infoDiv">  
                <b>Rifiuti:</b>
				<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                <p>Rifiuti riciclati/differenziati (in % sul totale): <b><span id="valoreRifiuti"></span>%</b></p>
                
                <input type="button" value="Chiudi" onclick="$('.infoDiv').hide();" />
		</div>
		
        <div id="infoSupplyChain" class="infoDiv">  
                <b>Supply Chain:</b>
				<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                <p>Beni e servizi sostenibili (in % sul totale): <b><span id="valoreSupplyChain"></span>%</b></p>
                
                <input type="button" value="Chiudi" onclick="$('.infoDiv').hide();" />
		</div>
        
        <div id="infoMobilita" class="infoDiv">  
                <b>Mobilità:</b>
				<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                <p>Km percorsi su trasporto pubblico in % sul totale: <b><span id="valoreMobilita"></span>%</b></p>
                
                <input type="button" value="Chiudi" onclick="$('.infoDiv').hide();" />
		</div>


    <scene>
    <navigationInfo headlight='false' type='"NONE"'></navigationInfo>
	
	<Transform translation='0 0 0' >
		<Inline DEF="Luci" nameSpaceName="Luci" url="Modelli/Luci.x3d" />
	</Transform>

	<Transform translation='0 0 0' id="BoxInterazione" >
		<Inline DEF="BoxInterazione" nameSpaceName="BoxInterazione" url="Modelli/BoxInterazione.x3d" />
	</Transform>	

	<Transform translation='0 0 0' >
		<Inline DEF="Telecamere" nameSpaceName="Telecamere" url="Modelli/Telecamere.x3d" />
	</Transform>

	<Transform translation='0 0 0' id="Statics">
		<Inline DEF="Statici" nameSpaceName="Statici" url="Modelli/Statici.x3d" />
	</Transform>
	
	<Transform translation='0 0 0' >
		<Inline DEF="Rifiuti" nameSpaceName="Rifiuti" url="Modelli/Rifiuti/Rifiuti.x3d" />
	</Transform>
	
	<Transform translation='0 0 0' >
		<Inline DEF="SupplyChain" nameSpaceName="SupplyChain" url="Modelli/Supply Chain/SupplyChain.x3d" />
	</Transform>
	
	<Transform translation='0 0 0' >
	<Inline DEF="Energia" nameSpaceName="Energia" url="Modelli/Energia/Energia.x3d" />
	</Transform>
	
	<Transform translation='0 0 0' id="Acqua1" >
	</Transform>

	<Transform translation='0 0 0' id="Acqua2" >
	</Transform>

	<Transform translation='0 0 0' id="Acqua3" >
	</Transform>

		
	<Transform translation='0 0 0' id="Innovazione1" >
	</Transform>

	<Transform translation='0 0 0' id="Innovazione2" >
	</Transform>

	<Transform translation='0 0 0' id="Innovazione3" >
	</Transform>


	<Transform translation='0 0 0' id="Materiali1" >
	</Transform>

	<Transform translation='0 0 0' id="Materiali2" >
	</Transform>

	<Transform translation='0 0 0' id="Materiali3" >
	</Transform>



	<Transform translation='0 0 0' id="Mobilita1" >
	</Transform>

	<Transform translation='0 0 0' id="Mobilita2" >
	</Transform>

	<Transform translation='0 0 0' id="Mobilita3" >
	</Transform>


		
    </scene>

</x3d>
   
	 <br clear="all" />

   <button id="bInnovazione" onclick="goTo('Innovazione');"> Innovazione</button>
    <button id="bGovernance" onclick="goTo('Governance');" >Governance</button>
    <button id="bPersonale" onclick="goTo('Personale');">Pol. Personale</button>
    <button id="bStudenti" onclick="goTo('Studenti');">Pol. Studenti</button>
    <button id="bMateriali" onclick="goTo('Materiali');">Materiali</button>
    <button id="bEnergia" onclick="goTo('Energia');">Energia</button>
    <button id="bAcqua" onclick="goTo('Acqua');">Acqua</button>
    <button id="bRifiuti" onclick="goTo('Rifiuti');">Rifiuti</button>
    <button id="bSupplyChain" onclick="goTo('SupplyChain');">Supply Chain</button>
    <button id="bMobilita" onclick="goTo('Mobilita');">Mobilità</button>
    <button id="bGenerale" onclick="goToMenu();">Generale</button>
	<br />
    <div style="margin-left:26%">
    <label>Anno:
    <select onchange="changeYear(this.options[this.selectedIndex].value);">
	  <option value="2010" selected>2010</option>
	  <option value="2011">2011</option>
	  <option value="2012">2012</option>
	</select>	
    </label>
    </div>

<br clear="all" />


<script type='text/javascript' src='js/x3dom.js'></script>

<script type="text/javascript">
   
	 init();
	 
</script>




</body>

</html>