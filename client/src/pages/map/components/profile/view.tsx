import React, { useEffect, useState } from "react";
import { useSelector } from "../../../../shared/store/store";
import { alien } from "../../../../assets/img";
import { animalColorGet } from "../../../../shared/service";

export const Profile: React.FC = () => {
  const { user } = useSelector((state) => state);
  const [isSeting, setIsSeting] = useState(false);

  useEffect(() => {
    animalColorGet(user.user.id)
  }, [user])

  const handleSetting = () => {
    setIsSeting(!isSeting);
  };

  return (
    <div>
      <div className="h-[400px] w-[320px] bg-[#EAE4DD] rounded-2xl flex flex-col gap-2 justify-center items-center">
        <div className="w-[100px] h-[100px] bg-yellow-400 p-2 rounded-full">
          <img src={alien} alt="" />
        </div>
        <div className="w-full h-[170px] border-t-2 border-[#ff7235] p-4 flex justify-center">
          {isSeting ? (
            <div>
              <ul>
                <li className="mb-4">
                  <input
                    type="text"
                    value={user.user.lastName}
                    className="p-2 border-2 rounded-md border-[#5a578b] bg-[#EAE4DD] duration-500 hover:bg-[#ff7235]/50"
                  />
                </li>
                <li>
                  <input
                    type="text"
                    value={user.user.name}
                    className="p-2 border-2 rounded-md border-[#5a578b] bg-[#EAE4DD] duration-500 hover:bg-[#ff7235]/50"
                  />
                </li>
              </ul>
            </div>
          ) : (
            <div>
              <ul className="text-2xl">
                <li className="mb-4">{user.user.lastName}</li>
                <li>{user.user.name}</li>
              </ul>
            </div>
          )}
        </div>
        <div className="flex flex-col justify-center items-center gap-2">
          <div>
            <button
              className="
                rounded-3xl p-2 
                bg-none 
                duration-700
                hover:bg-[#5a578b]
                hover:scale-110
              "
              onClick={handleSetting}
            >
              {isSeting ? "Сохранить" : "Изменить данные"}
            </button>
          </div>
          <div>
            <button
              className="
                rounded-3xl p-2 
                bg-none 
                duration-700
                hover:bg-[#5a578b]
                hover:scale-110
              "
            >
              Изменить пароль
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};
