import React, { useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { setUser } from "../../shared/store/store";

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
    // dispatch(setUser(user))

    if (!result.ok) {
      // navigate("/map")
    }
  };

  return (
    <main className="h-screen w-screen flex justify-center items-center">
      <section className="z-50 w-[300px] h-[350px] rounded-xl bg-orange-300 flex flex-col justify-around items-center">
        <section>
          <h1 className="text-4xl">Вход</h1>
        </section>
        <section className="w-[200px]">
          <form ref={formData}>
            <section className="h-[300px] flex flex-col items-center justify-around">
                <input type="text" name="login" className="p-2 border-2 border-blue-950 bg-gray-50 focus:border-blue-800 hover:border-blue-800"/>
                <input type="password" name="password" className="p-2 border-2 border-blue-950 bg-gray-50 focus:border-blue-800 hover:border-blue-800"/>
              <section className="text-white">
                <section>
                  <button onClick={handle} className="w-[100px] bg-blue-950 rounded p-2 mt-2">Войти</button>
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
