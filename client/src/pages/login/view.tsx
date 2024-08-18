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
        lastName: formData.current[0].value,
        password: formData.current[1].value
    };

    await fetchPost(data);
  };

  return (
    <main>
      <div>
        <section>
          <h1>Login</h1>
        </section>
        <form ref={formData}>
          <input type="text" name="login" />
          <input type="password" name="password" />
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
