(ns parcial1
  (:require [clojure.set :as set]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; ¡¡¡¡LEA CON ATENCIÓN!!! ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; I. En esta evaluación se encontrará con un conjunto de funciones que deberá completar de acuerdo a su premisa respectiva. Así que tómese la 
;;    libertad de modificar el cuerpo de la función según lo considere apropiado.
;;    De igual modo, siempre que lo estime conveniente puede crear otras funciones que sirvan de auxiliares. Eso sí, nunca modifique el nombre 
;;    ni la cantidad de argumentos de las funciones a completar.
;;    Puede importar y requerir las librerías que juzgue convenientes (e.g. clojure.string ó clojure.set). 

;;  II. Al conectarse al REPL ¡NO! seleccione la opción :test, déjela sin marcar y presione OK en el cuadro de diálogo.

;; III. Cada función cuenta con un conjunto de tests que verifican que trabaje correctamente. Antes que nada asegúrese de evaluar los namespaces.
;;      En primer lugar, evalúe este namespace (Ctrl + Alt + c y luego Enter) y posteriormente diríjase donde se encuentran los tests test/parcial1test.clj
;;      y evalúe ese namespace también. Para correr los tests, oprima las teclas Ctrl + Alt + c luego Shift + t
;;      Alternativamente, puede presionar F1, escribir 'Calva' y buscar en el menú de comandos la opción "Run All Tests".
;;      También puede evaluar la función (run-all-tests) que se encuentra en el bloque de comentarios en el archivo de tests. En el mismo 
;;      archivo puede, de igual modo, correr tests individuales pasándole el nombre del test a la función (run-test).

;;      Si pasaran todos los tests de las preguntas obligatorias, usted habrá aprobado la evaluación con la máxima calificación. 

;;      Puede correr los tests la cantidad de veces que necesite y, obviamente, cuando haya realizado una modificación en este archivo y quiera volver
;;      a correr los tests debe guardar el archivo y evaluar la función que quiera probar.

;;      Si surge algún error al correr los tests, guarde todo, evalúe primero este namespace, luego diríjase a la carpeta test y evalúe el archivo 
;;      parcial1test.clj. 
;;      Recuerde que para evaluar todo el namespace debe presionar Ctrl + Alt + c y luego Enter. O en su defecto presionar F1 y buscar la opción 
;;      "Load / Evaluate Current File..." en el menu de comandos de Calva. 

;;      No tiene permitido bajo ninguna circunstancia modificar el archivo de tests. Caso contrario quedará reprobado.

;; IV. Utilice la forma (comment ) para explorar las respuestas y deje allí las cosas que intentó. Se considerará en la evaluación. 

;; V. No olvide guardar (Ctrl + k y luego s) sus progresos y cuando esté listo diríjase al ícono de Source Control/ Control de versiones, haga click 
;;     en el ícono al lado derecho de Commit y, finalmente, haga click sobre la opción Commit & Push para subir los cambios a su repositorio.

;; VI. Si tiene dudas o problemas no dude en presentar su consulta en el Foro del Aula Virtual. 


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; COMPLETE LAS SIGUIENTES FUNCIONES ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; 1. La siguiente función recibirá un vector de strings y deberá devolver un vector de booleanos, donde cada uno marcará true si la palabra 
;;    ubicada en tal posición es un diptongo o un hiato. En caso contrario, marcará false. 
;;    PISTA: Convendría definir las vocales; el namespace clojure.set puede ser de ayuda. (valor 5pts).


;; Profe, para lograr la siguiente función me planteé que, para detectar si una palabra
;; es diptongo o hiato, debe tener obligadamente dos vocales seguidas juntas, de forma secuencial.
;; Para esto, ya que tenemos un vector de palabras como input, busque una funcion que me itere cada elemento.
;; Usé mapv, que me pareció ideal para esto. Luego utilizo re-find para encontrar dos vocales consecutivas con una expresión regular
;; que especifica que debe haber 2 coincidencias, y "%" que representa cada palabra de nuestro vector, es decir, el parámetro.
;; Finalmente, como necesito que el output sean booleanos, uso la funcion "boolean" para obtener True si se detecta diptongo o hiato.
(defn obtener-diptongos-y-hiatos
  [palabras]
  (mapv #(boolean (re-find #"[aeiouáéíóú]{2}" %))
        palabras))

(def palabras ["hola" "Javier" "hiato" "compra" "murciélago"])

(def output (obtener-diptongos-y-hiatos palabras))
(println output)




;; 2. La siguiente función recibe como parámetro un número que representa la temperatura en grados celcius. Si la 
;;    temperatura se encuentra por debajo de los 0 grados debe retornar "helado"; si se encuentra entre los 0 y los 10 
;;    grados inclusive debe retornar "frío"; entre los 11 y los 18 grados inclusive debe retornar "templado"; dentro de los
;;    19 y 27 grados inclusive debe retornar "fresco"; dentro de los 28 y los 35 grados debe retornar "caluroso"; y para las 
;;    temperaturas mayores a 35 grados debe retornar "calor extremo". La función debe ser capaz de procesar tanto números enteros
;;    como decimales y proveer la respuesta correcta. (valor 2.5pts)
;;    Nota: Escriba los strings a retornar tal cual están acá, pues si cambia algo (espacios, mayúsculas) los tests no pasarán.
;;          Preste atención a la posición de los argumentos en las expresiones booleanas (< a b) ó 'a < b' no es igual que (< b a),
;;          es decir, 'b < a'.

(defn evaluar-temperatura 
  [temp]
   (cond
    (< temp 0) "helado"
    (<= temp 10) "frío"
    (<= temp 18) "templado"
    (<= temp 27) "fresco"
    (<= temp 35) "caluroso"
    :else "calor extremo"))

(println (evaluar-temperatura 46.9))

;; 3. Esta función recibe como argumentos un mapa con la forma {:producto "producto1" :precio 3920} y un número que representa el descuento
;;    que se le va a aplicar. Debe devolver el mismo mapa con el precio actualizado. (valor 2.5pts)



;; En esta consigna, uso la keyword local let para asignar un valor a una variable llamada precio-descuento (el precio con el descuento incluido).
;; Este valor se calcula al multiplicar el precio del producto por la diferencia entre 1 y el resultado de dividir el descuento por 100.
;; Finalmente, uso la función assoc para crear un nuevo mapa copiando el mapa del producto original, pero actualizando el valor del precio
;; con el valor de la variable mencionada anteriormente precio-descuento. Como return,
;; la función devuelve este un nuevo mapa/diccionario que contiene ya el producto con el descuento aplicado.

(defn aplicar-descuento
  [producto descuento]
  (let [precio-descuento (* (:precio producto) (- 1 (/ descuento 100)))]
    (assoc producto :precio precio-descuento)))

(def lista_precios {:producto "arroz" :precio 1000.1})
(def descuento 10)


(println (aplicar-descuento lista_precios descuento)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; EJERCICIO ADICIONAL ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; 4. Esta función recibe un vector de palabras y debe retornar un vector excluyendo las palabras repetidas sin importar si están escritas 
;;    en mayúsculas o contienen alguna letra en mayúscula (e.g. "retornar", "RETORNAR", "Retornar" y "retOrnar" son la misma palabra). Todas
;;    las palabras del vector output deben estar en minúsculas. (valor 2.5 pts)

;; En esta última consigna, uso clojure.string/lower-case para que las palabras que estén escritas
;; en mayúsculas o que contengan alguna letra en mayúscula sean tratadas como minúsculas.
;; Luego, elimino las palabras duplicadas con la función distinct.
;; Finalmente, vuelvo a convertir el output en un vector con la función vec.
;; Cabe destacar que para resolver este ejercicio utilicé la macro de clojure "->>", que es muy similar
;; a la pipe que estamos usando en R, específicamente con la librería dplyr. Esto me facilitó encadenar las distintas funciones
;; que pensé para la función.

(defn obtener-palabras-unicas
  [vec-palabras]
  (->> vec-palabras
       (map clojure.string/lower-case)
       distinct
       vec))


(println (obtener-palabras-unicas ["PaRRiLLa" "parrillA" "PARRILLA" "paRrilla" "palaBRA" "PALabra" "Otra" "OTra"]))
         
(comment


  )