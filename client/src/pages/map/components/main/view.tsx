import React, { useEffect, useRef, useState } from "react";

export const Main: React.FC = () => {
    const canvasRef = useRef<HTMLCanvasElement>(null)
    const [blocks, setBlocks] = useState({});

    const getBloks = async () => {
      try {
        const resolve = await fetch("http://localhost:9090/blocks");
  
        if (resolve.status === 200) {
          const result = await resolve.json();
  
          setBlocks(result[1]);
        }
      } catch (error) {
        console.error(`Error get bloks: ${error}`);
      }
    };

    useEffect(() => {
      const canvas = canvasRef.current;
      if (canvas) {
        const ctx = canvas.getContext("2d");
        if (ctx) {
          // getBloks()
          ctx.fillStyle = "#5490de"
          ctx.fillRect(0, 10, 30, 400)
          ctx.fillStyle = "#781f19"
          ctx.fillRect(30, 460, 570, 30)
        }
      }
    }, [blocks]);

  return (
    <main className="h-full flex flex-row items-center justify-around w-full gap-2">
      <div className="h-[600px] p-2 overflow-x-hidden overflow-y-scroll flex-col flex gap-2">
        <section className="w-[300px] h-[200px] flex-none border flex rounded-xl duration-500 hover:shadow-lg">
          <div className="w-20 h-20 m-2">
            <img
              src="https://i.pinimg.com/originals/0a/dd/87/0add874e1ea0676c4365b2dd7ddd32e3.jpg"
              alt="usm"
              className="rounded-full"
            />
          </div>
        </section>
      </div>
      <div className="w-[1100px] h-[500px] border-4 border-orange-400 rounded-xl">
        <canvas ref={canvasRef} width={1100} height={500}></canvas>
      </div>
    </main>
  );
};
