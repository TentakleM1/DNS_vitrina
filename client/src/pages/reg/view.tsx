import React, { useRef } from "react";
import { useNavigate } from "react-router-dom";

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

    console.log('created user:', result);
  } catch (error) {
    throw new Error(`Error: not workig POST: ${error}`);
  }
};

export const Reg: React.FC = () => {
  const formData = useRef(null);
  const navigate = useNavigate();

  const handle = async (e) => {
    e.preventDefault();

    const data = {
        name: formData.current[0].value,
        password: formData.current[1].value,
        lastName: formData.current[2].value,
        root: formData.current[3].checked,
    };

    await fetchPost(data);
  };
  return (
    <main>
      <div>
        <section>
          <h1>Create User</h1>
        </section>
        <form ref={formData}>
          <input type="text" name="name" placeholder={'name'}/>
          <input type="password" name="password" placeholder={'password'}/>
          <input type="text" name="lastName" placeholder={'last name'}/>
          <input type="checkbox"/>
          <button onClick={handle}>Create</button>
          <button
              onClick={() => {
                navigate("/map");
              }}
          >
            Back
          </button>
        </form>
      </div>
    </main>
  );
};
