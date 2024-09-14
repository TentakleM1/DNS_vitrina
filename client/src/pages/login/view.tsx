import React, { useEffect, useRef, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { setUser } from "../../shared/store/user/userSlice";

const fetchPost = async (data: Record<string, string>) => {
  try {
    const response = await fetch("http://localhost:9090/sign-in", {
      method: "post",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });

    if (!response.ok) {
      throw new Error(`Error! status: ${response.status}`);
    }

    return await response.json();

  } catch (error) {
    throw new Error(`Error: not workig GET: ${error}`);
  }
};

// UserApi.getUsers()

export const Login: React.FC = () => {
  const formData = useRef(null);
  const navigate = useNavigate();
  const dispatch = useDispatch()
  const user = useSelector((state) => state.user)

  console.log(user)
  const handle = async (e): Promise<void> => {
    e.preventDefault();
    const data: {lastName: string, password: string} = {
        lastName: formData.current[0].value,
        password: formData.current[1].value
    };

    const result = await fetchPost(data);

    if (!result.ok) {
      dispatch(setUser(result))
      navigate("/map")
    }
  };

  return (
    <main className="h-screen w-screen flex justify-center items-center">
      <section className="z-50 w-[300px] h-[350px] rounded-xl bg-neutral-800/50 flex flex-col justify-around items-center text-slate-50">
        <section className="m-2">
          <h1 className="text-4xl text-slate-50 font-bold">Вход</h1>
        </section>
        <section className="w-[200px]">
          <form ref={formData}>
            <section className="h-[250px] flex flex-col items-center justify-around">
                <input type="text" name="login" placeholder="Фамилия" className="p-2 border-2 rounded-md border-orange-600 bg-amber-900/70 focus:border-orange-400 hover:border-orange-400"/>
                <input type="password" name="password" placeholder="Пароль" className="p-2 border-2 rounded-md border-orange-600 bg-amber-900/70 duration-500 focus:border-orange-400 hover:border-orange-400"/>
              <section>
                <section>
                  <button onClick={handle} className="w-[100px] bg-orange-700 rounded p-2 mt-2 duration-500 hover:bg-orange-400">Войти</button>
                </section>
                <section>
                </section>
              </section>
            </section>
          </form>
        </section>
      </section>
      <div className="absolute blur-sm">
        <img src="https://storage.weacom.ru/v8112/1f/omcwAdvboxA.jpg" alt="" />
      </div>
    </main>
  );
};
