import React, { useRef } from "react";
import './index.css'

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
      throw new Error(`Error! status: ${response.status}`)
    }

    const result = await response.json()

    console.log("created user:", result)
  } catch (error) {
    throw new Error(`Error: not workig POST: ${error}`)
  }
};

export const CreateStaff: React.FC = () => {
  const form = useRef(null);

  const handle = async (e) => {
    e.preventDefault();
    const formData = new FormData(form.current)

    const data = {
      ...formData,
      root: form.current[3].checked,
    };
    await fetchPost(data)
  };

  return (
    <div>
      <section className="w-[300px] h-[350px] border-2 rounded-xl border-orange-500 flex flex-col justify-around items-center">
        <section className="w-[200px]">
          <form ref={form}>
            <section className="h-[250px] flex flex-col items-center justify-around">
              <input
                type="text"
                name="name"
                placeholder="Фамилия"
                className="p-2 border-2 rounded-md border-orange-600 duration-500 focus:border-orange-400 hover:bg-orange-200/50"
              />
              <input
                type="text"
                name="lastName"
                placeholder="Имя"
                className="p-2 border-2 rounded-md border-orange-600 duration-500 focus:border-orange-400 hover:bg-orange-200/50"
              />
              <input
                type="password"
                name="password"
                placeholder="Пароль"
                className="p-2 border-2 rounded-md border-orange-600 duration-500 focus:border-orange-400 hover:bg-orange-200/50"
              />
              <div className="checkbox-wrapper">
                <input id="cbx" type="checkbox" />
                <label className="cbx" htmlFor="cbx"></label>
                <label className="lbl" htmlFor="cbx">
                  Дать полный доступ ?
                </label>
              </div>
              <section>
                <section>
                  <button
                    onClick={handle}
                    className="text-orange-500 rounded-xl p-2 duration-500 hover:bg-orange-500 hover:text-amber-50"
                  >
                    Создать
                  </button>
                </section>
              </section>
            </section>
          </form>
        </section>
      </section>
    </div>
  );
};
