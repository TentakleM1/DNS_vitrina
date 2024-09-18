import React, { useRef } from "react";
import "./index.css";
import { alien } from "../../../../assets/img/index";
import { useSelector } from "../../../../shared/store/store";

const fetchPost = async (data) => {
  try {
    const response = await fetch("http://localhost:9090/create-user", {
      method: "post",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });

    if (!response.ok) {
      throw new Error(`Error! status: ${response.status}`);
    }

    const result = await response.json();

    console.log("created user:", result);
  } catch (error) {
    throw new Error(`Error: not workig POST: ${error}`);
  }
};

export const CreateStaff: React.FC = () => {
  const form = useRef(null);
  const { stuff } = useSelector((state) => state);

  const handle = async (e) => {
    e.preventDefault();
    const formData = new FormData(form.current);

    const data = {
      ...formData,
      root: form.current[3].checked,
    };
    await fetchPost(data);
  };

  return (
    <div className="h-[600px] w-2/4 flex justify-around gap-4">
      <div className="p-4 bg-[#EAE4DD] rounded-xl overflow-x-hidden overflow-y-scroll flex-col flex gap-2">
        {stuff.stuff.map((card) => {
          // if (card.root) return;
          return (
            <section
              key={card.id}
              onClick={() => choiceUsm(card.id)}
              className="w-[300px] h-[100px] flex-none flex flex-col gap-2 overflow-hidden cursor-pointer rounded-xl duration-500 hover: hover:shadow-lg hover:bg-orange-500 hover:text-amber-50"
            >
              <div className="flex items-center justify-around">
                <div className="w-20 h-20 m-2">
                  <img
                    src="https://i.pinimg.com/originals/0a/dd/87/0add874e1ea0676c4365b2dd7ddd32e3.jpg"
                    alt="usm"
                    className="rounded-full"
                  />
                </div>
                <div>
                  <span>{`${card.lastName} ${card.name}`}</span>
                </div>
                <div>
                  <svg
                    width="30px"
                    height="30px"
                    viewBox="0 0 24 24"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      d="M15 16L20 21M20 16L15 21M4 21C4 17.134 7.13401 14 11 14M15 7C15 9.20914 13.2091 11 11 11C8.79086 11 7 9.20914 7 7C7 4.79086 8.79086 3 11 3C13.2091 3 15 4.79086 15 7Z"
                      stroke="#000000"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                  </svg>
                </div>
              </div>
            </section>
          );
        })}
      </div>
      <section className="w-[300px] h-[450px] text-gray-800 font-bold rounded-3xl bg-[#EAE4DD] flex flex-col justify-center items-center">
        <section>
          <form ref={form}>
            <section className="flex flex-col items-center justify-around gap-4">
              <label htmlFor="name">Имя</label>
              <input
                type="text"
                name="name"
                className="p-2 border-2 rounded-md border-[#5a578b] bg-[#EAE4DD] duration-500 hover:bg-[#ff7235]/50"
              />
              <label htmlFor="lasName">Фамилия</label>
              <input
                type="text"
                name="lastName"
                className="p-2 border-2 rounded-md border-[#5a578b] bg-[#EAE4DD] duration-500 hover:bg-[#ff7235]/50"
              />
              <label htmlFor="password">Пароль</label>
              <input
                type="password"
                name="password"
                className="p-2 border-2 rounded-md border-[#5a578b] bg-[#EAE4DD] duration-500 hover:bg-[#ff7235]/50"
              />
              <div className="checkbox-wrapper">
                <label className="lbl" htmlFor="cbx">
                  Дать полный доступ ?
                </label>
                <input id="cbx" type="checkbox" />
                <label className="cbx" htmlFor="cbx"></label>
              </div>
              <section>
                <section>
                  <button
                    onClick={handle}
                    className="text-amber-50 bg-[#ff7235] rounded-2xl p-2 duration-500 hover:scale-110"
                  >
                    Создать
                  </button>
                </section>
              </section>
            </section>
          </form>
        </section>
      </section>
      <div className="absolute bottom-5 right-5 w-[300px]">
        <img src={alien} alt="" />
      </div>
    </div>
  );
};
