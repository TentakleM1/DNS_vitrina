import React, { useRef } from "react";
import { useNavigate } from "react-router-dom";

const fetchPost = async (data) => {
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

    const result = await response.json();

    console.log(result);
  } catch (error) {
    throw new Error(`Error: not workig GET: ${error}`);
  }
};

export const Login: React.FC = () => {
  const formData = useRef(null);
  const navigate = useNavigate();

  const handle = async (e) => {
    e.preventDefault();
    const data = {
        login: formData.current[0].value,
        password: formData.current[1].value
    };

    await fetchPost(data);
  };

  return (
    <main className="h-screen flex justify-center items-center">
      <section className="w-[300px] h-[350px] rounded-xl bg-orange-300 flex flex-col justify-around items-center">
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
                  <button
                      className="w-[100px] border border-blue-950 rounded p-2 mt-2"
                      onClick={() => {
                        navigate("/sign-up");
                      }}
                  >
                    sign up
                  </button>
                </section>
              </section>
            </section>
          </form>
        </section>
      </section>
    </main>
  );
};
