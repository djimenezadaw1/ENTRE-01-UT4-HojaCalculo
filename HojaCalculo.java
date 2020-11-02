    
    /**
     *  Un objeto de esta clase representa a una sencilla
     *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
     *  En cada fila la empresa "apunta" los ingresos y gastos en 
     *  una determinada fecha
     * 
     * @author - Daniel Jiménez  
     *  
     */
    public class HojaCalculo
    {
        private String nombre;
        private Fila fila1;
        private Fila fila2;
        private Fila fila3;
    
        /**
         * Constructor  
         * Crea la hoja de cálculo con el nombre indicado 
         * e inicializa las filas al valor null (inicialmente
         * la hoja se crea sin filas)
         */
        public HojaCalculo(String nombre)    {
            this.nombre = nombre;
            this.fila1 = null;
            this.fila1 = null;
            this.fila1 = null;
    
        }
    
        /**
         * accesor para el nombre de la hoja
         */
        public String getNombre() {
            return this.nombre;
    
        }
    
        /**
         * accesor para la fila1
         */
        public Fila getFila1() {
            return fila1;
    
        }
    
        /**
         * accesor para la fila2
         */
        public Fila getFila2() {
            return fila2;
    
        }
    
        /**
         * accesor para la fila3
         */
        public Fila getFila3() {
            return fila3;
    
        }
    
        /**
         * Devuelve el nº de filas de la hoja
         * (dependerá de cuántas filas estén a null)
         */
        public int getNumeroFilas() {
            int filasExist = 0;
            if (fila1 != null){
              filasExist = filasExist + 1;  
            }
            if (fila2 != null){
              filasExist = filasExist + 1;  
            }
            if (fila3 != null){
              filasExist = filasExist + 1;  
            }
            return filasExist;
    
        }
    
        /**
         * Devuelve true si la hoja está completa
         * (tiene exactamente 3 filas)
         */
        public boolean hojaCompleta() {
            return (getNumeroFilas() == 3);
    
        }
    
        /**
         * Se añade una nueva fila a la hoja
         * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
         * Si no está completa se añade la fila a la hoja teniendo en cuenta
         * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
         */
        public void addFila(Fila fila) {
          if (hojaCompleta()){
              System.out.printf("%s no se puede añadir en %s", fila.getId(), getNombre());
          }
          else{ 
          if(fila1 == null){
            fila1 = fila;
              }
          else{ 
              if (fila2 == null){
              fila2 = fila;
              }
          else{
              fila3 = fila;
          }
         }
        }
    
        }
    
        /**
         * Dada la información a guardar en una fila el método
         * crea la fila y la añade a la hoja
         * (evita repetir código)
         */
        public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
             Fila filaNueva = new Fila(id, fecha, ingresos, gastos);
             this.addFila(filaNueva);
    
        }
    
        /**
         * Calcula y devuelve el total de ingresos entre
         * todas las filas que incluye la hoja
         */
        public double getTotalIngresos() {
            double totalIn= 0.0;
            if(fila1 != null){
             totalIn= totalIn + fila1.getIngresos();   
            }
            if(fila2 != null){
             totalIn= totalIn + fila2.getIngresos();   
            }
            if(fila3 != null){
             totalIn= totalIn + fila3.getIngresos();   
            }
            return totalIn;
    
        }
    
        /**
         * Calcula y devuelve el total de gastos
         * entre todas las filas que incluye la hoja
         */
        public double getTotalGastos() {
            double totalG= 0.0;
            if(fila1 != null){
             totalG= totalG + fila1.getGastos();   
            }
            if(fila2 != null){
             totalG= totalG + fila2.getGastos();   
            }
            if(fila3 != null){
             totalG= totalG + fila3.getGastos();   
            }
            return totalG;
            
    
        }
    
        /**
         * Calcula y devuelve el total del beneficio
         * entre todas las filas que incluye la hoja
         */
        public double getBeneficio() {
            double totalBen= 0.0;
            if(fila1 != null){
             totalBen= totalBen + fila1.getBeneficio();   
            }
            if(fila2 != null){
             totalBen= totalBen + fila2.getBeneficio();   
            }
            if(fila3 != null){
             totalBen= totalBen + fila3.getBeneficio();   
            }
            return totalBen;
    
        }
        /**
         * Representación textual de la hoja
         * con el formato exacto que indica el enunciado
         */
        public String toString() {
            String hojaPantalla = String.format("%n%n%s%n%8s%15s%17s%15s%17s", 
            this.nombre, " ", "FECHA", "INGRESOS", "GASTOS", "BENEFICIO");
            if(getNumeroFilas()==3){
                hojaPantalla = hojaPantalla + "\n" + fila1.toString();
                hojaPantalla = hojaPantalla + "\n" + fila2.toString();
                hojaPantalla = hojaPantalla + "\n" + fila3.toString();  
            }
            else{
               if(getNumeroFilas()==2){
                   hojaPantalla = hojaPantalla + "\n" + fila1.toString(); 
                   hojaPantalla = hojaPantalla + "\n" + fila2.toString();   
               }
               else{
                hojaPantalla = hojaPantalla + "\n" + fila1.toString();   
                }
            }     
            hojaPantalla = hojaPantalla + "\n" + "----------------------------------------------------------------------------------------";
            String resultadoTotal = String.format("%38.2f€%15.2f€%15.2f€", getTotalIngresos(), getTotalGastos(), getBeneficio());
            hojaPantalla = hojaPantalla + "\n" + resultadoTotal;
            return hojaPantalla;
    
        }
        /**
         * Devuelve un duplicado de la hoja actual.
         * El nombre de la hoja duplicada será "Duplicada HojaX"
         * Al duplicar la hoja se duplicarán también las filas que contenga
         */
        public HojaCalculo duplicarHoja() {
        HojaCalculo hojaDuplicada = new HojaCalculo("Duplicada "+ this.getNombre());   
         if(getNumeroFilas()==3){
           Fila filaNueva1 = fila1.duplicar();
           hojaDuplicada.addFila(filaNueva1);
           Fila filaNueva2 = fila2.duplicar();
           hojaDuplicada.addFila(filaNueva2);
           Fila filaNueva3 = fila3.duplicar();
           hojaDuplicada.addFila(filaNueva3);   
         }
         else{
           if(getNumeroFilas()==2){
               Fila filaNueva1 = fila1.duplicar();
               hojaDuplicada.addFila(filaNueva1);
               Fila filaNueva2 = fila2.duplicar();
               hojaDuplicada.addFila(filaNueva2);  
           }
           else{
               Fila filaNueva1 = fila1.duplicar();
               hojaDuplicada.addFila(filaNueva1);
            }
         }        
        return hojaDuplicada;
       }
   
}
