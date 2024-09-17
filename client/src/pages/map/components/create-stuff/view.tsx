import React, { useRef } from "react";
import "./index.css";
import { alien } from "../../../../assets/img/index";

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
    <div>
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
