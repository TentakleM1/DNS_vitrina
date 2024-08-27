import React, { useRef } from "react";
import { useNavigate } from "react-router-dom";

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

  const handle = async (e): Promise<void> => {
    e.preventDefault();
    const data: {lastName: string, password: string} = {
        lastName: formData.current[0].value,
        password: formData.current[1].value
    };

    const result = await fetchPost(data);

    if (!result.ok) {
      navigate("/map")
    }
  };

  return (
    <main>
      <div>
        <section>
          <h1>Login</h1>
        </section>
        <form ref={formData}>
          <input type="text" name="login" value={'Поливаева'} />
          <input type="password" name="password" value={123456} />
          <button onClick={handle}>sign in</button>
          <button
            onClick={() => {
              navigate("/sign-up");
            }}
          >
            sign up
          </button>
        </form>
      </div>
    </main>
  );
};
