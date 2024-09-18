import UserApi from "../../api/user-api/UserApi";

export const animalColorGet = async (id: number) => {
  try {
    const animalResponse = await UserApi.getAnimal(id);
    const animal = animalResponse[0]
    const colorResponse = await UserApi.getColor(id);
    const color = colorResponse[0]
    console.log(color);
  } catch (error) {
    console.error(error);
  }
};
