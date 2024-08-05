import React, { useRef } from "react";
import { useNavigate } from "react-router-dom";

const fetchPost = async (data) => {
  try {
    const response = await fetch("http://localhost:9090/sign-up", {
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

export const Reg: React.FC = () => {
  const formData = useRef(null);
  const navigate = useNavigate();

  const handle = async (e) => {
    e.preventDefault();
    const data = new FormData(formData.current);

    fetchPost(data);
  };
  return (
    <main>
      <div>
        <section>
          <h1>Registration</h1>
        </section>
        <form ref={formData} onClick={handle}>
          <input type="text" name="login" />
          <input type="password" name="password" />
          <button>sign un</button>
          <button
            onClick={() => {
              navigate("/");
            }}
          >
            sign in
          </button>
        </form>
      </div>
    </main>
  );
};
