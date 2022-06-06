

paquete  libreta de direcciones ;
	

	importar  Java . útil _ escáner ;
	importar  Java . útil _ mapa hash ;
	importar  Java . útil _ iterador ;
	importar  Java . io .*;
	/**
	*
	@autor mex9999
	*/
	 Libreta de direcciones de clase  pública {
	

	

	    /**
	     * @para argumenta los argumentos de la línea de comando
	     */
	    public  static  void  main ( String [] args ) {
	        
	

	        
	        HashMap < String , String > mapaCon = new  HashMap < String , String >(); // creacion del objeto de tipo hashmap
	        Scanner  leer = nuevo  Scanner ( System . in );    
	        
	        
	        int  opc , prohibición = 0 ;
	        String  telefono , nombre ;
	        sistema _ fuera _ println ( "**AGENDA TELEFONICA**\n" );
	        
	        hacer
	        {
	            prueba {
	                
	            sistema _ fuera _ println ( "\nSeleccione la opción deseada:\n" );
	                sistema _ fuera _ println ( "DATOS DE CARGA ------------- [1]" );
	                sistema _ fuera _ println ( "DATOS GUARDAR------------[2]" );
	                sistema _ fuera _ println ( "MOSTRAR CONTACTOS --------- [3]" );
	                sistema _ fuera _ println ( "NUEVO NUMERO------------[4]" );
	                sistema _ fuera _ println ( "BORRAR CONTACTO ----------- [5]" );
	                sistema _ fuera _ println ( "SALIR -------------------- [6]" );
	            
	                opc = leer . siguienteInt ();
	                
	                /// Menú de opciones
	                interruptor ( opc )
	                {
	                    caso  1 :
	                        cargar ( mapaCon ); // llamado a metodo cargar datos
	                        romper ;
	                    
	                    caso  2 :
	                        guardar ( mapaCon ); // llamado a metodo guardar datos
	                        romper ;
	                    
	                    caso  3 :
	                        lista ( mapaCon );  // llamado a mostrar datos de hasmap
	                        romper ;
	                        
	                    caso  4 :  
	                        
	                        sistema _ fuera _ println ( "Inserte el nuevo telefono:" );
	                        teléfono = leer . siguiente ();
	                        sistema _ fuera _ println ( "Inserte el nombre del contacto:" );
	                        nombre = leer . siguiente ();
	                        crear ( mapaCon , telefono , nombre );  // llamado a metodo crear contacto
	                        romper ;
	                    caso  5 :
	                        
	                        sistema _ fuera _ println ( "Inserte el telefono a eliminar:" );
	                        teléfono = leer . siguiente ();
	                        
	                        borrar ( mapaCon , telefono );  // llamado a metodo de eliminar contacto
	                        romper ;
	                     
	                    caso  6 :
	                        sistema _ fuera _ println ( "Saliendo\n" );
	                        prohibición = 1 ;
	                        romper ;
	                        
	                    predeterminado :
	                        sistema _ fuera _ println ( "Opcion incorrecta\n" );
	                        romper ;
	                        
	                    
	                }
	            }
	            captura ( Excepción  e )
	            {
	                sistema _ fuera _ println ( "ERROR!!\n" );
	                romper ;
	

	            }
	        } while ( prohibición == 0 );
	        
	    }
	    
	    ///////////////////////////////////////////////
	    //////////////////////////////////////////////
	    //Metodos
	    /////////////////////////////////////////////
	    /////////////////////////////////////////////
	     lista vacía estática  pública ( HashMap < String , String > mapaCon ) 
	    {
	        Iterador < String > iterador = mapaCon . conjunto de teclas (). iterador ();  //creo un iterador para poder recorrer el hashmap
	        
	        sistema _ fuera _ println ( "Contactos:\n" );
	        sistema _ fuera _ println ( "Teléfono\t|\tNombre" );
	        sistema _ fuera _ println ( "------------------------" );
	        while ( iterator . hasNext ())                                 //en un ciclo recorremos el hashmap
	        {
	            String  llave = iterador . siguiente ();                      // el iterador se llama llave que esta funcionando como referencia en la clave del hashmap
	            
	            sistema _ fuera _ println ( " " + llave + "\t|\t" + mapaCon . get ( llave )); // se muestra en pantalla el contenido del hashmap
	        }
	        
	    }
	    
	    // método de añadir contacto
	     creación de vacío estático  público ( HashMap < String , String > mapaCon , String tel , String nom )   
	    {           
	        
	            if ( mapaCon . contiene Clave ( tel ))
	            {
	                sistema _ fuera _ println ( "\nError!\nNo se puede registrar dos veces el mismo telefono\n" ); // mensaje si el telefono ya existe
	            }
	            
	            más
	            {
	                mapa Con . poner ( tel , nom );  //si no existe se crea el contacto
	                sistema _ fuera _ println ( "\nContacto agregado" );
	            }
	        
	    }
	    
	    // metodo de borrar
	     eliminación de vacío estático  público ( HashMap < String , String > mapaCon , String tel )  
	    {
	        if ( mapaCon . containsKey ( tel ))         //si el telefono existe se procede a removerlo del hashmap
	        {  
	            sistema _ fuera _ println ( "\nContacto eliminado: " + mapaCon . get ( tel )+ "\n" );
	            mapa Con . eliminar ( tel );            // se recuerdan las coincidencias con el dato clave
	            
	        }
	        más
	            sistema _ fuera _ println ( "\nEl telefono no existe\n" ); // si no entonces se manda un mensaje
	        
	        
	    }
	    
	    // metodo de cargar datos desde archivo csv
	     carga vacía estática  pública ( HashMap < String , String > m ) 
	    {
	        String  inputFilename = "C:\\Users\\52222\\Documents\\NetBeansProjects\\AddressBook\\src\\main\\java\\mex9999\\addressbook\\input.csv" ;
	        Cadena  a [];                /// matriz auxiliar
	        
	        BufferedReader  bufferedReader = null ;
	

	        prueba {
	            bufferedReader = new  BufferedReader ( new  FileReader ( inputFilename ));
	

	             línea de cuerda ;
	            while (( línea = bufferedReader . readLine ()) != null ) {
	                a = línea . dividir ( "," );        // se llena el array con los datos separados por la ","
	                m _ poner ( un [ 0 ], un [ 1 ]);           // se llena el hashmap con los datos del array
	            }
	        } captura ( IOException  e ) {
	            sistema _ fuera _ println ( "IOException atrapada al leer: " + e . getMessage ());
	        } finalmente {
	            prueba {
	                if ( bufferedReader != null ) {
	                    lector almacenado en búfer . cerrar ();
	                    sistema _ fuera _ println ( "\nContactos cargados" );
	                }
	            } captura ( IOException  e ) {
	                sistema _ fuera _ println ( "IOException atrapada al cerrar: " + e . getMessage ());
	            }
	        }
	

	    }
	    
	    //método de guardar datos en archivo csv
	     guardado de vacío estático  público ( HashMap < String , String > m ) 
	    {
	        Iterador < Cadena > iterador = m . conjunto de teclas (). iterador ();
	        String  inputFilename = "C:\\Users\\52222\\Documents\\NetBeansProjects\\AddressBook\\src\\main\\java\\mex9999\\addressbook\\input.csv" ;
	        
	        BufferedWriter  bufferedWriter = null ;
	

	        prueba {
	            bufferedWriter = new  BufferedWriter ( new  FileWriter ( inputFilename ));
	           
	           while ( iterator . hasNext ())                                 //en un ciclo recorremos el hashmap
	        {
	            String  llave = iterador . siguiente ();                      // el iterador se llama llave que esta funcionando como referencia en la clave del hashmap
	            
	

	            escritor almacenado en búfer . escribir ( llave + "," + m . obtener ( llave )+ "\n" );   // Se escribe el hashmap en el archivo input
	        }
	           
	            }
	         captura ( IOException  e ) {
	            sistema _ fuera _ println ( "IOException atrapada al escribir: " + e . getMessage ());
	        } finalmente {
	            prueba {
	                if ( bufferedWriter != null ) {
	                    escritor almacenado en búfer . cerrar ();
	                    sistema _ fuera _ println ( "\nCambios guardados" );
	                }
	            } captura ( IOException  e ) {
	                sistema _ fuera _ println ( "IOException atrapada al cerrar: " + e . getMessage ());
	            }
	        }
	    }
	} 
