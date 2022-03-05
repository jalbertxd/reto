# reto
#Se crearon tres microservicios:
#1: Microservicio de seguridad (8003): 
#  1.1: "/api/auth" (POST): método que recibe como parámetros usuario y password, si los datos son correctos devuelve un token:
![image](https://user-images.githubusercontent.com/90285201/156874486-1b319ab0-e1be-4e78-b0c7-84a8e1044894.png)

2: Microservicio de tipo de cambio (8004):
  2.1: "/api/tipoCambio" (GET): devuelve un listado con todos los tipos de cambio regstrados:
  ![image](https://user-images.githubusercontent.com/90285201/156874606-420d6669-1c70-48fe-a1af-3f18979f3ce4.png)
  
  2.2: "/api/tipoCambio/{id}" (GET): devuelve el tipo de cambio que tiene como identificador el {id} del parámetro
  ![image](https://user-images.githubusercontent.com/90285201/156875036-32868524-63a5-40a6-970f-616f71ba97db.png)
  
  2.2: "/api/tipoCambio" (POST): agregar un tipo de cambio:
  ![image](https://user-images.githubusercontent.com/90285201/156874712-2f51dbf4-65aa-489a-b122-d7e514bc0306.png)
  
  2.3: "/api/tipoCambio" (PUT): actualiza un tipo de cambio:
  ![image](https://user-images.githubusercontent.com/90285201/156874903-62204f5e-956b-44d2-8120-3ab564c1bb57.png)
  
  2.4: "/api/tipoCambio/{id}" (DELETE): elimina un tipo de cambio:
  ![image](https://user-images.githubusercontent.com/90285201/156874974-6593dfb6-fe09-4abf-a8ed-cfedc9fc30d1.png)
  
  2.5: "/api/tipoCambio/applyTipoCambio" (POST): aplica el tipo de cambio a un monto
  ![image](https://user-images.githubusercontent.com/90285201/156875080-ae514592-b26b-4c2d-9691-f830f362af8a.png)

3: Microservicio de Gateway (8005): 
  3.1: Microservicio de seguridad con el filtro del gateway:
  ![image](https://user-images.githubusercontent.com/90285201/156875179-51dd08e4-a380-4903-9738-dd2b6788a52c.png)
  
  3.2: Microserviio de tipo  de cambio con el filtro del  gateway y la seguridad integrada:
  ![image](https://user-images.githubusercontent.com/90285201/156875211-c4ac6e7a-6328-4d64-9976-50b7c160ac6f.png)
  
  ![image](https://user-images.githubusercontent.com/90285201/156875216-80fc83a1-4f64-43b1-9524-678b4f275204.png)
  
  En caso no se le envíe el token correcto:
  ![image](https://user-images.githubusercontent.com/90285201/156875242-885bd4f9-cea8-406f-ae5e-bb96784ea0f2.png)

IMPORTANTE: 
- todos los microservicios tienen su archivo Dockerfile dentro del repositorio que sirvio para crear la imagen de cada microservicio
- las pruebas se hicieron con los contenedores en ejecución de cada microservicio:

![image](https://user-images.githubusercontent.com/90285201/156875345-454083e1-107d-4ace-9c5d-6c4484ac5594.png)

![image](https://user-images.githubusercontent.com/90285201/156875353-3256aab2-32a0-404b-90b5-6936af8eaaff.png)


  
