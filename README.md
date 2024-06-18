# Android Rick and Morty API Playground

## Descripción
`android-rick-and-morty-api-playground` es una aplicación de Android que muestra información de personajes de la popular serie de televisión "Rick and Morty". Utiliza la API [Rick and Morty API](https://rickandmortyapi.com/) para obtener los datos de los personajes y presentarlos en una lista dentro de la aplicación.

## Características
- Visualización de personajes de "Rick and Morty" en un RecyclerView.
- Detalle de cada personaje.
- Imágenes de los personajes cargadas utilizando Glide.
- Peticiones de red gestionadas con Retrofit.
- Uso de corutinas para operaciones asíncronas.

## Permisos
La aplicación requiere los siguientes permisos:
- `INTERNET`: Necesario para realizar las peticiones a la API de "Rick and Morty".

## Instalación
Para clonar y ejecutar esta aplicación en tu entorno local, sigue estos pasos:

1. Clona el repositorio
    ```bash
    git clone https://github.com/fathooo/android-rick-and-morty-api-playground.git
    ```
2. Abre el proyecto en Android Studio.
3. Construye el proyecto.
4. Ejecuta la aplicación en un emulador o dispositivo real.

## Uso
1. Al abrir la aplicación, se muestra una lista de personajes de "Rick and Morty".
2. Desliza por la lista para ver más personajes.
3. Toca cualquier personaje para ver más detalles sobre él.